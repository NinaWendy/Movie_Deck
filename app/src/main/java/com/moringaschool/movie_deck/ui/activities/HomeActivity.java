package com.moringaschool.movie_deck.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Movies;
import com.moringaschool.movie_deck.ui.adapters.RecyclerViewAdapter;
import com.moringaschool.movie_deck.ui.adapters.RecyclerViewInterface;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface {
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
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, HomeActivity.this, movies.getResults());
        movieRecyclerList.setAdapter(recyclerViewAdapter);
        //define layout manager
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false);
        movieRecyclerList.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(int position) {
        String movieName = movies.getResults().get(position).getOriginalTitle();
        FirebaseDatabase.getInstance().getReference("Favourites").push().child("Movie").setValue(movieName);
        Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show();
    }
}