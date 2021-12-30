package com.noname.nf.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

// this class will implementing parcelable
public class FilmModel implements Parcelable {

    // here is variables for data that will parsing from json
    String title;
    String thumbnail;
    String releaseDate;
    List<Genre> genres;
    float rating;
    String country;
    String category;
    float popularity;
    String synopsis;
    int vote;

    // constructor
    public FilmModel(String title, String thumbnail, String releaseDate, List<Genre> genres, float rating, String country, String category, float popularity, String synopsis, int vote) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.rating = rating;
        this.country = country;
        this.category = category;
        this.popularity = popularity;
        this.synopsis = synopsis;
        this.vote = vote;
    }

    // getter method
    protected FilmModel(Parcel in) {
        title = in.readString();
        thumbnail = in.readString();
        releaseDate = in.readString();
        rating = in.readFloat();
        country = in.readString();
        category = in.readString();
        popularity = in.readFloat();
        synopsis = in.readString();
        vote = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(releaseDate);
        dest.writeFloat(rating);
        dest.writeString(country);
        dest.writeString(category);
        dest.writeFloat(popularity);
        dest.writeString(synopsis);
        dest.writeInt(vote);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public float getRating() {
        return rating;
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

    public int getVote() {
        return vote;
    }

    // to string method

    @Override
    public String toString() {
        return "FilmModel{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genres=" + genres +
                ", rating=" + rating +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", popularity=" + popularity +
                ", synopsis='" + synopsis + '\'' +
                ", vote=" + vote +
                '}';
    }
}
