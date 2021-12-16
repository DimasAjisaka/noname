package com.noname.nf.repositories;

import com.noname.nf.request.FilmApiClient;

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
    // calling entry method in repo
}
