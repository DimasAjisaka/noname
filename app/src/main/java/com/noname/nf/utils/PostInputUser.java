package com.noname.nf.utils;

import com.noname.nf.models.PostInputUserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostInputUser {
    @POST("criteria")
    Call<PostInputUserModel> PostDataIntoAhpLogic(@Body PostInputUserModel postInputUserModel);
}
