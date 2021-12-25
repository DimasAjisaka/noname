package com.noname.nf.request;

public class FilmApiClient {
    // 1. make live data list movie model

    private static FilmApiClient instance;

    // making global runnable here

    public static FilmApiClient getInstance(){
        if (instance == null) {
            instance = new FilmApiClient();
        } return instance;
    }

    // 2. create film api client live data
    // 3. create get film method that will returning live data
    // 4. create entry genre method to call through classes
    // 5. create retrieve class that will implementing runnable -> retrieving data from REST API by runnable
}
