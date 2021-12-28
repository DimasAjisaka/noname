package com.noname.nf.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.noname.nf.models.PostInputUserModel;

public class PostResponse {
    @SerializedName("results")
    @Expose()
    private PostInputUserModel postInputUserModel;

    public PostInputUserModel getPostInputUserModel() {
        return postInputUserModel;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "postInputUserModel=" + postInputUserModel +
                '}';
    }
}
