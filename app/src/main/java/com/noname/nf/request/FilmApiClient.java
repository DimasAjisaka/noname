package com.noname.nf.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.noname.nf.Results;
import com.noname.nf.executors.AppExecutors;
import com.noname.nf.models.FilmModel;
import com.noname.nf.models.MovieModel;
import com.noname.nf.response.RecommendedResponse;
import com.noname.nf.response.TmdbResponse;
import com.noname.nf.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class FilmApiClient {

    // 1. make live data list movie model
    private MutableLiveData<List<FilmModel>> mutableLiveData;

        // tmdb
        private MutableLiveData<List<MovieModel>> mutableLiveDataTmdb;

    private static FilmApiClient instance;

    // making global runnable here
    private RetrieveFilmRunnable retrieveFilmRunnable;

        // tmdb
        private RetrieveFilmRunnableTmdb retrieveFilmRunnableTmdb;

    public static FilmApiClient getInstance(){
        if (instance == null) {
            instance = new FilmApiClient();
        } return instance;
    }

    // 2. create film api client live data
    private FilmApiClient() {
        mutableLiveData = new MutableLiveData<>();
        mutableLiveDataTmdb = new MutableLiveData<>();
    }

    // 3. create get film method that will returning live data
    public LiveData<List<FilmModel>> getFilms() { return mutableLiveData; }

        // tmdb
        public LiveData<List<MovieModel>> getMovie() { return mutableLiveDataTmdb; }

    // 4. create entry genre method to call through classes
    public void recommendedFilm() {
        if (retrieveFilmRunnable != null) {
            retrieveFilmRunnable = null;
        }

        retrieveFilmRunnable = new RetrieveFilmRunnable();

        final Future myHandler = AppExecutors.getInstance().networkIO().submit(retrieveFilmRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            // cancelling the retrofit call
            myHandler.cancel(true);
        },3000, TimeUnit.MILLISECONDS);
    }

        // tmdb
        public void searchMovie(String query,int page) {
            if (retrieveFilmRunnable != null) {
                retrieveFilmRunnable = null;
            }

            retrieveFilmRunnableTmdb = new RetrieveFilmRunnableTmdb(query,page);

            final Future myHandler = AppExecutors.getInstance().networkIO().submit(retrieveFilmRunnableTmdb);

            AppExecutors.getInstance().networkIO().schedule(() -> {
                // cancelling the retrofit call
                myHandler.cancel(true);
            },3000, TimeUnit.MILLISECONDS);
        }

    // 5. create retrieve class that will implementing runnable -> retrieving data from REST API by runnable
    private class RetrieveFilmRunnable implements Runnable {

        boolean cancelRequest;

        public RetrieveFilmRunnable() {
            cancelRequest = false;
        }

        @Override
        public void run() {

            // getting the response object
            try {
                Response resultResponse = getResults().execute();

                if (cancelRequest) {
                    return;
                }

                if (resultResponse.code() == 200) {
                    assert resultResponse.body() != null;
                    List<FilmModel> list = new ArrayList<>(((RecommendedResponse)resultResponse.body()).getFilmModel());

                    mutableLiveData.postValue(list);
                } else {
                    assert resultResponse.errorBody() != null;
                    String error = resultResponse.errorBody().string();
                    Log.v("tag","Error"+error);
                    mutableLiveData.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                mutableLiveData.postValue(null);
            }
        }

        // get results method
        private Call<RecommendedResponse> getResults() {
            return Service.getFilmApi().recommendedFilm();
        }
    }

        // retrieve runnable for tmdb
        private class RetrieveFilmRunnableTmdb implements Runnable {

            String query;
            boolean cancelRequest;
            int page;

            public RetrieveFilmRunnableTmdb(String query, int page) {
                this.query = query;
                this.page = page;
                cancelRequest = false;
            }

            @Override
            public void run() {

                // getting the response object
                try {
                    Response response = getMovie(query,page).execute();

                    if (cancelRequest) {
                        return;
                    }

                    if (response.code() == 200) {
                        assert response.body() != null;
                        List<MovieModel> listTmdb = new ArrayList<>(((TmdbResponse)response.body()).getMovies());
                        mutableLiveDataTmdb.postValue(listTmdb);
                    } else {
                        assert response.errorBody() != null;
                        String error = response.errorBody().string();
                        Log.v("tag","Error"+error);
                        mutableLiveDataTmdb.postValue(null);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    mutableLiveDataTmdb.postValue(null);
                }
            }

            private Call<TmdbResponse> getMovie(String query,int page) { return Service.getFilmApi().searchMovie(Credentials.API_KEY,query,page); }
        }
}
