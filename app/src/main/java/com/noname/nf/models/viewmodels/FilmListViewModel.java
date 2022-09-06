package com.noname.nf.models.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.noname.nf.models.FilmModel;
import com.noname.nf.models.MovieModel;
import com.noname.nf.repositories.FilmRepository;

import java.lang.reflect.Modifier;
import java.util.List;

public class FilmListViewModel extends ViewModel {
    private FilmRepository filmRepository;

    public FilmListViewModel() {
        filmRepository = FilmRepository.getInstance();
    }

    // create live data get film that will returning film repo -> get film
    public LiveData<List<FilmModel>> getResults() { return filmRepository.getResults(); }

        // tmdb
        public LiveData<List<MovieModel>> getMovie() { return filmRepository.getMovie(); }

    // calling entry method in view model
    public void recommendedFilm() { filmRepository.recommendedFilm(); }

        // tmdb
        public void searchMovie(String query,int page) {
            filmRepository.searchMovie(query,page);
        }
}
