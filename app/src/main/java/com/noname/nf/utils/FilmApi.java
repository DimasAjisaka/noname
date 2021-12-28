package com.noname.nf.utils;

import com.noname.nf.models.FilmModel;
import com.noname.nf.models.PostInputUserModel;
import com.noname.nf.response.PostResponse;
import com.noname.nf.response.RecommendedResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FilmApi {

    // post criteria
    @POST("compare")
    Call<PostResponse> PostDataIntoAhpLogic(@Body PostInputUserModel postInputUserModel);

    // get recommended results
    @GET("compareResults")
    Call<RecommendedResponse> recommendedFilm(String id);
}
