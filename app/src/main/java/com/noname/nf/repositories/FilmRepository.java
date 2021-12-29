package com.noname.nf.repositories;

import androidx.lifecycle.LiveData;

import com.noname.nf.models.FilmModel;
import com.noname.nf.models.MovieModel;
import com.noname.nf.request.FilmApiClient;

import java.util.List;

public class FilmRepository {
    private static FilmRepository instance;
    private final FilmApiClient filmApiClient;

    public static FilmRepository getInstance(){
        if (instance == null){
            instance = new FilmRepository();
        } return instance;
    }

    private FilmRepository() {
        filmApiClient = FilmApiClient.getInstance();
    }

    // create live data get film that will returning film api client . get film
    public LiveData<List<FilmModel>> getResults() { return filmApiClient.getFilms(); }

    // tmdb
    public LiveData<List<MovieModel>> getMovie() { return filmApiClient.getMovie(); }

    // calling entry method in repo
    public void recommendedFilm() { filmApiClient.recommendedFilm(); }

    // tmdb

    public void searchMovie (String query, int page) {
        filmApiClient.searchMovie(query,page);
    }
}
