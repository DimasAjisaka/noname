package com.noname.nf.models;

import java.util.ArrayList;

public class PostInputModel {
    ArrayList<String> stringCompare;
    ArrayList<Float>  compareValue;

    public PostInputModel(ArrayList<String> stringCompare, ArrayList<Float> compareValue) {
        this.stringCompare = stringCompare;
        this.compareValue = compareValue;
    }

    public ArrayList<String> getStringCompare() {
        return stringCompare;
    }

    public void setStringCompare(ArrayList<String> stringCompare) {
        this.stringCompare = stringCompare;
    }

    public ArrayList<Float> getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(ArrayList<Float> compareValue) {
        this.compareValue = compareValue;
    }

    @Override
    public String toString() {
        return "PostInputModel{" +
                "stringCompare=" + stringCompare +
                ", compareValue=" + compareValue +
                '}';
    }
}
