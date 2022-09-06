package com.noname.nf.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noname.nf.R;

public class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView title,genre,rating;
    ImageView poster;
    OnFilmListener onFilmListener;

    public FilmViewHolder(@NonNull View itemView, OnFilmListener onFilmListener) {
        super(itemView);

        title = itemView.findViewById(R.id.ttl);
        genre = itemView.findViewById(R.id.gnr);
        rating = itemView.findViewById(R.id.rating);
        poster = itemView.findViewById(R.id.poster);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onFilmListener.onMovieClick(getAdapterPosition());
    }
}
