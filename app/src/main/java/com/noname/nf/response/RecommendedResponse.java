package com.noname.nf.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.noname.nf.models.FilmModel;

import java.util.List;

public class RecommendedResponse {

    // 1. create list film model variable as film
    @SerializedName("results")
    @Expose()
    private List<FilmModel> filmModel;

    // 2. create method getFilm that will returning film
    public List<FilmModel> getFilmModel(){
        return filmModel;
    }

    // 3. make it to string method

    @Override
    public String toString() {
        return "RecommendedResponse{" +
                "filmModel=" + filmModel +
                '}';
    }
}
