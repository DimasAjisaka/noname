package com.noname.nf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.noname.nf.adapters.FilmRecycleViewAdapter;
import com.noname.nf.adapters.OnFilmListener;
import com.noname.nf.models.FilmModel;
import com.noname.nf.models.viewmodels.FilmListViewModel;

public class Results extends AppCompatActivity implements OnFilmListener {

//    private FilmModel mFilm;
//    ImageView poster;
//    TextView title,genres;

    private FilmListViewModel filmListViewModel;
    private RecyclerView recyclerView;
    private FilmRecycleViewAdapter filmRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        recyclerView = findViewById(R.id.recycleView);

        filmListViewModel = new ViewModelProvider(this).get(FilmListViewModel.class);

        ObservingAnyChanges();
        recommendedFilm();
        ConfigureRecycleView();
//        AdapterStatic adapterStatic = new AdapterStatic(this,title,genres,rating,posterPath);
//        recyclerView.setAdapter(adapterStatic);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        recyclerView.setTranslationX(800f);
//        recyclerView.setAlpha(0f);
//        recyclerView.animate().translationX(0f).alpha(1f).setDuration(300).setStartDelay(10000);
//        recommendedFilm();
//        searchMovie("fast",1);

//        poster = findViewById(R.id.poster);
//        title = findViewById(R.id.titleFilm);
//        genres = findViewById(R.id.genres);

        // parsing thumbnail
//        Glide.with(this).load(Credentials.POSTER_URL+mFilm.getThumbnail()).into(poster);
    }

    private void ObservingAnyChanges() {
        filmListViewModel.getResults().observe(this, filmModels -> {
            if(filmModels != null) {
                for (FilmModel ignored : filmModels) {
                    filmRecycleViewAdapter.setmFilms(filmModels);
                }
            }
        });
    }

//    private void ObservingAnyChanges(){
//        filmListViewModel.getMovie().observe(this, movieModels -> {
//            if(movieModels != null) {
//                for (MovieModel model: movieModels) {
//                    filmRecycleViewAdapter.setmMovies(movieModels);
//                    Log.v("tag","on changed"+model.getTitle());
//                }
//            }
//        });
//    }

    private void recommendedFilm(){
        filmListViewModel.recommendedFilm();
    }
//
//    // tmdb
//    private void searchMovie(String query, int page) { filmListViewModel.searchMovie(query,page); }

    private void ConfigureRecycleView() {
        filmRecycleViewAdapter = new FilmRecycleViewAdapter(this);
        recyclerView.setAdapter(filmRecycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onMovieClick(int position) {

    }

//    public void setmFilm(FilmModel mFilm) {
//        this.mFilm = mFilm;
//    }
}