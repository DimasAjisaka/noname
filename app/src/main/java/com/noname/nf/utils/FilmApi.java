package com.noname.nf.utils;

import com.noname.nf.models.PostInputUserModel;
import com.noname.nf.response.PostResponse;
import com.noname.nf.response.RecommendedResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FilmApi {

    // post criteria
    @POST("compare")
    Call<PostResponse> PostDataIntoAhpLogic(@Body PostInputUserModel postInputUserModel);

    // get recommended results
    @GET("comparisonResults")
    Call<RecommendedResponse> recommendedFilm();
}
