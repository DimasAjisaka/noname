package com.noname.nf.request;

import com.noname.nf.utils.Credentials;
import com.noname.nf.utils.FilmApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(Credentials.BASE_API_URL).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = retrofitBuilder.build();
    private static FilmApi filmApi = retrofit.create(FilmApi.class);

    public static FilmApi getFilmApi() {
        return filmApi;
    }
}
