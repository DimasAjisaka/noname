package com.noname.nf.models;

public class PostInputUserModel {

    String[] criteriaCompare;
    float[] criteriaValue;

    public PostInputUserModel(String[] criteriaCompare, float[] criteriaValue) {
        this.criteriaCompare = criteriaCompare;
        this.criteriaValue = criteriaValue;
    }
}