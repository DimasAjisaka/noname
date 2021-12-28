package com.noname.nf.models;

import android.os.Parcel;
import android.os.Parcelable;

// this class will implementing parcelable
public class FilmModel implements Parcelable {

    // here is variables for data that will parsing from json
    String title;
    String thumbnail;
    String releaseDate;
    String genre;
    float ratting;
    String country;
    String category;
    float popularity;
    String synopsis;
    int vote;

    // 1. make constructor
    public FilmModel(String title, String thumbnail, String releaseDate, String genre, float ratting, String country, String category, float popularity, String synopsis, int vote) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.ratting = ratting;
        this.country = country;
        this.category = category;
        this.popularity = popularity;
        this.synopsis = synopsis;
        this.vote = vote;
    }

    // 2. make getter method
    protected FilmModel(Parcel in) {
        title = in.readString();
        thumbnail = in.readString();
        releaseDate = in.readString();
        genre = in.readString();
        ratting = in.readFloat();
        country = in.readString();
        category = in.readString();
        popularity = in.readFloat();
        synopsis = in.readString();
        vote = in.readInt();
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

    public String getThumbnail() {
        return thumbnail;
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

    public float getPopularity() {
        return popularity;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getVote() {return vote; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(releaseDate);
        dest.writeString(genre);
        dest.writeFloat(ratting);
        dest.writeString(country);
        dest.writeString(category);
        dest.writeFloat(popularity);
        dest.writeString(synopsis);
        dest.writeInt(vote);
    }

    @Override
    public String toString() {
        return "FilmModel{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre='" + genre + '\'' +
                ", ratting=" + ratting +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", viewers=" + popularity +
                ", synopsis='" + synopsis + '\'' +
                ", vote=" + vote +
                '}';
    }
}
