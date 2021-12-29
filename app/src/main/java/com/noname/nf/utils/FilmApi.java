package com.noname.nf.utils;

import com.noname.nf.models.PostInputModel;
import com.noname.nf.response.PostResponse;
import com.noname.nf.response.RecommendedResponse;
import com.noname.nf.response.TmdbResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FilmApi {

    // post criteria
//    @POST("compare")
//    Call<PostResponse> PostDataIntoAhpLogic(@Field("stringCompare []") ArrayList<String> stringCompare);

    @POST("compare")
    Call<PostResponse> PostDataIntoAhpLogic(PostInputModel postInputModel);

    // get recommended results
    @GET("comparisonResults")
    Call<RecommendedResponse> recommendedFilm();

    // get from tmdb
    @GET("search/movie")
    Call<TmdbResponse> searchMovie(@Query("api_key") String key,
                                          @Query("query") String query,
                                          @Query("page") int page);
}
