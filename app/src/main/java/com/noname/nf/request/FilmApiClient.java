package com.noname.nf.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.noname.nf.executors.AppExecutors;
import com.noname.nf.models.FilmModel;
import com.noname.nf.response.RecommendedResponse;

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

    private static FilmApiClient instance;

    // making global runnable here
    private RetrieveFilmRunnable retrieveFilmRunnable;

    public static FilmApiClient getInstance(){
        if (instance == null) {
            instance = new FilmApiClient();
        } return instance;
    }

    // 2. create film api client live data
    private FilmApiClient() { mutableLiveData = new MutableLiveData<>(); }

    // 3. create get film method that will returning live data
    public LiveData<List<FilmModel>> getFilms() { return mutableLiveData; }

    // 4. create entry genre method to call through classes
    public void recommendedFilm(String id) {
        if (retrieveFilmRunnable != null) {
            retrieveFilmRunnable = null;
        }

        retrieveFilmRunnable = new RetrieveFilmRunnable(id);

        final Future myHandler = AppExecutors.getInstance().networkIO().submit(retrieveFilmRunnable);

        AppExecutors.getInstance().networkIO().schedule(() -> {
            // cancelling the retrofit call
            myHandler.cancel(true);
        },3000, TimeUnit.MILLISECONDS);
    }

    // 5. create retrieve class that will implementing runnable -> retrieving data from REST API by runnable
    private class RetrieveFilmRunnable implements Runnable {

        private final String id;
        boolean cancelRequest;

        public RetrieveFilmRunnable(String id) {
            this.id = id;
            cancelRequest = false;
        }

        @Override
        public void run() {

            // getting the response object
            try {
                Response resultResponse = getResults(id).execute();

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
        private Call<RecommendedResponse> getResults(String id) {
            return Service.getFilmApi().recommendedFilm(id);
        }
    }
}
