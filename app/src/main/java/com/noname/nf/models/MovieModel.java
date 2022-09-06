package com.noname.nf.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    private int id;
    private String title;
    private String poster_path;
    private String tagline;
    private String release_date;
    private float vote_average;
    private String overview;
    private int runtime;

    public MovieModel(int id, String title, String poster_path, String tagline, String release_date, float vote_average, String overview, int runtime) {
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
        this.tagline = tagline;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.overview = overview;
        this.runtime = runtime;
    }

    protected MovieModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        poster_path = in.readString();
        tagline= in.readString();
        release_date = in.readString();
        vote_average = in.readFloat();
        overview = in.readString();
        runtime = in.readInt();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public String getTagline() { return tagline; }

    public String getReleaseDate() {
        return release_date;
    }

    public float getVoteAverage() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public int getRuntime() { return runtime; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(tagline);
        dest.writeString(release_date);
        dest.writeFloat(vote_average);
        dest.writeString(overview);
        dest.writeInt(runtime);
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", tagline='" + tagline + '\'' +
                ", release_date='" + release_date + '\'' +
                ", vote_average=" + vote_average +
                ", overview='" + overview + '\'' +
                ", runtime=" + runtime +
                '}';
    }
}
