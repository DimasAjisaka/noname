package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.noname.nf.models.FilmModel;
import com.noname.nf.utils.Credentials;

import java.util.List;

public class Results extends AppCompatActivity {

    private FilmModel mFilm;
    ImageView poster;
    TextView title,genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        poster = findViewById(R.id.poster);
        title = findViewById(R.id.titleFilm);
        genres = findViewById(R.id.genres);

        // parsing thumbnail
//        Glide.with(this).load(Credentials.POSTER_URL+mFilm.getThumbnail()).into(poster);
    }

    public void setmFilm(FilmModel mFilm) {
        this.mFilm = mFilm;
    }
}