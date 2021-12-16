package com.noname.nf.models.viewmodels;

import androidx.lifecycle.ViewModel;

import com.noname.nf.repositories.FilmRepository;

public class FilmListViewModel extends ViewModel {
    private FilmRepository filmRepository;

    public FilmListViewModel() {
        filmRepository = FilmRepository.getInstance();
    }

    // create live data get film that will returning film repo -> get film
    // calling entry method in view model
}
