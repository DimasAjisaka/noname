package com.noname.nf.models;

import com.google.gson.annotations.SerializedName;

public class PostInputUserModel {

    String[] criteriaCompare;
    float[] criteriaValue;

    public PostInputUserModel(String[] criteriaCompare, float[] criteriaValue) {
        this.criteriaCompare = criteriaCompare;
        this.criteriaValue = criteriaValue;
    }
}
