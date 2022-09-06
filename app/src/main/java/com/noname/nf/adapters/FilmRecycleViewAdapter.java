package com.noname.nf.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.noname.nf.R;
import com.noname.nf.models.FilmModel;
import com.noname.nf.utils.Credentials;

import java.util.List;

public class FilmRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FilmModel> mFilms;
    // tmdb
//    private List<MovieModel> mMovies;
    private final OnFilmListener onFilmListener;

    public FilmRecycleViewAdapter(OnFilmListener onFilmListener) {
        this.onFilmListener = onFilmListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_film_view_model,parent,false);
        return new FilmViewHolder(view,onFilmListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        String rattingText =String.valueOf(mFilms.get(i).getRating());
        ((FilmViewHolder)holder).title.setText(mFilms.get(i).getTitle());
        ((FilmViewHolder)holder).rating.setText(rattingText);
        ((FilmViewHolder)holder).genre.setText((CharSequence) mFilms.get(i).getGenres());

        Glide.with(holder.itemView).load(Credentials.POSTER_URL+mFilms.get(i).getThumbnail()).into(((FilmViewHolder)holder).poster);
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
