package com.moringaschool.movie_deck.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Movies;
import com.moringaschool.movie_deck.ui.adapters.RecyclerViewAdapter;

public class HomeActivity extends AppCompatActivity {
    Movies movies;
    RecyclerView movieRecyclerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        movies = (Movies) getIntent().getSerializableExtra("Response");
        //prints the number of objects we wil receive
        Log.e("Test TAG", "onCreate:" + movies.getResults().size());
        // Lookup the recyclerview in activity layout
        movieRecyclerList = (RecyclerView) findViewById(R.id.recyclerView);
        //connect recycler view to its adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(HomeActivity.this, movies.getResults());
        movieRecyclerList.setAdapter(recyclerViewAdapter);
        //define layout manager
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false);
        movieRecyclerList.setLayoutManager(layoutManager);
    }
}