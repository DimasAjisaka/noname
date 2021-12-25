package com.noname.nf.models;

import android.os.Parcel;
import android.os.Parcelable;

// this class will implementing parcelable
public class FilmModel implements Parcelable {
    // here is variables for data that will parsing from json
    String title;
    String thubnail;
    String releaseDate;
    String genre;
    float ratting;
    String country;
    String category;
    float viewers;
    String synopsis;

    // 1. make constructor

    public FilmModel(String title, String thubnail, String releaseDate, String genre, float ratting, String country, String category, float viewers, String synopsis) {
        this.title = title;
        this.thubnail = thubnail;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.ratting = ratting;
        this.country = country;
        this.category = category;
        this.viewers = viewers;
        this.synopsis = synopsis;
    }

    // 2. make getter method

    protected FilmModel(Parcel in) {
        title = in.readString();
        thubnail = in.readString();
        releaseDate = in.readString();
        genre = in.readString();
        ratting = in.readFloat();
        country = in.readString();
        category = in.readString();
        viewers = in.readFloat();
        synopsis = in.readString();
    }

    public static final Creator<FilmModel> CREATOR = new Creator<FilmModel>() {
        @Override
        public FilmModel createFromParcel(Parcel in) {
            return new FilmModel(in);
        }

        @Override
        public FilmModel[] newArray(int size) {
            return new FilmModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getThubnail() {
        return thubnail;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public float getRatting() {
        return ratting;
    }

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public float getViewers() {
        return viewers;
    }

    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(thubnail);
        dest.writeString(releaseDate);
        dest.writeString(genre);
        dest.writeFloat(ratting);
        dest.writeString(country);
        dest.writeString(category);
        dest.writeFloat(viewers);
        dest.writeString(synopsis);
    }

    @Override
    public String toString() {
        return "FilmModel{" +
                "title='" + title + '\'' +
                ", thubnail='" + thubnail + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre='" + genre + '\'' +
                ", ratting=" + ratting +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", viewers=" + viewers +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
