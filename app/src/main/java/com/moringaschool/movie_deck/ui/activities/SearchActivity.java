package com.moringaschool.movie_deck.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Constants;
import com.moringaschool.movie_deck.models.Movies;
import com.moringaschool.movie_deck.models.Result;
import com.moringaschool.movie_deck.network.clients.TmdbClient;
import com.moringaschool.movie_deck.network.interfaces.TmdbApi;
import com.moringaschool.movie_deck.ui.adapters.GridRecyclerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.gridMovies)
    RecyclerView gridMovies;
    List<Movies> moviesList;
    private List<Result> mMovies;
    Movies movies;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.search_view)
    androidx.appcompat.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //Bind views to activity
        ButterKnife.bind(this);

        //get response from intent
        movies = (Movies) getIntent().getSerializableExtra("Response");

        //prints the number of objects we wil receive
        Log.e("Test TAG", "onCreate:" + movies.getResults().size());

        //connect recycler view to its adapter
        GridRecyclerAdapter gridRecyclerAdapter = new GridRecyclerAdapter(SearchActivity.this, movies.getResults());
        gridMovies.setAdapter(gridRecyclerAdapter);

        //define layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL,false);
        gridMovies.setLayoutManager(linearLayoutManager);
        setSupportActionBar(toolbar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                TmdbApi tmdbApi = TmdbClient.getClient();
                Call<Movies> responseCall = tmdbApi
                        .searchMovie(
                                Constants.TMDB_API_KEY,
                                query,
                                "1");
                responseCall.enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        movies = response.body();
                        GridRecyclerAdapter gridRecyclerAdapter = new GridRecyclerAdapter(SearchActivity.this, movies.getResults());
                        gridMovies.setAdapter(gridRecyclerAdapter);
                        //define layout manager
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL,true);
                        gridMovies.setLayoutManager(linearLayoutManager);
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {
                        Log.e("Tag","Failed");
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}