package com.noname.nf.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.noname.nf.R;
import com.noname.nf.models.FilmModel;
import com.noname.nf.models.MovieModel;
import com.noname.nf.utils.Credentials;

import java.util.List;

public class FilmRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FilmModel> mFilms;
    // tmdb
    private List<MovieModel> mMovies;
    private final OnFilmListener onFilmListener;

    String[] title;
    String[] genres;
    float[] rating;
    String[] posterPath;

    public FilmRecycleViewAdapter(OnFilmListener onFilmListener, String[] title, String[] genres, float[] rating, String[] posterPath) {
        this.onFilmListener = onFilmListener;
        this.title = title;
        this.genres = genres;
        this.rating = rating;
        this.posterPath = posterPath;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_film_view_model,parent,false);
        return new FilmViewHolder(view,onFilmListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        String rattingText =String.valueOf(rating[i]);
        ((FilmViewHolder)holder).title.setText(title[i]);
        ((FilmViewHolder)holder).rating.setText(rattingText);
        ((FilmViewHolder)holder).genre.setText(genres[i]);

        Glide.with(holder.itemView).load(Credentials.POSTER_URL+posterPath[i]).into(((FilmViewHolder)holder).poster);
    }

    @Override
    public int getItemCount() {
        if (mFilms != null) {
            return mFilms.size();
        } return 0;
    }

    public void setmFilms(List<FilmModel> mFilms) {
        this.mFilms = mFilms;
        notifyDataSetChanged();
    }
}
