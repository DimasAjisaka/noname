package com.noname.nf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.noname.nf.R;
import com.noname.nf.utils.Credentials;

public class AdapterStatic extends RecyclerView.Adapter<AdapterStatic.ViewHolderStatic> {

    String[] title;
    String[] genre;
    String[] rating;
    String[] posterPath;
    Context context;

    public AdapterStatic(Context ct, String[] titles, String[] genres, String[] ratings, String[] posterPaths) {
        context = ct;
        genre = genres;
        title = titles;
        rating = ratings;
        posterPath = posterPaths;
    }

    @NonNull
    @Override
    public ViewHolderStatic onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_film_view_model,parent,false);
        return new ViewHolderStatic(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStatic holder, int position) {

        holder.title.setText(title[position]);
        holder.genre.setText(genre[position]);
        holder.rating.setText(rating[position]);
        Glide.with(holder.itemView).load(Credentials.POSTER_URL+posterPath[position]).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolderStatic extends RecyclerView.ViewHolder{

        TextView title,genre,rating;
        ImageView poster;

        public ViewHolderStatic(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.ttl);
            genre = itemView.findViewById(R.id.gnr);
            rating = itemView.findViewById(R.id.rating);
            poster = itemView.findViewById(R.id.poster);
        }
    }
}
