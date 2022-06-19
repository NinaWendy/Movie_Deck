package com.moringaschool.movie_deck.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Favourite;
import com.moringaschool.movie_deck.models.Result;
import com.moringaschool.movie_deck.ui.adapters.FavouritesAdapter;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    FavouritesAdapter favouritesAdapter;
    ArrayList<String> favList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        recyclerView = findViewById(R.id.favRecyclerView);
        database= FirebaseDatabase.getInstance().getReference("Favourites");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favList = new ArrayList<>();
        favouritesAdapter = new FavouritesAdapter(FavouritesActivity.this,favList);
        recyclerView.setAdapter(favouritesAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String title = dataSnapshot.child("Movie").getValue(String.class);
                    favList.add(title);
                }
                favouritesAdapter.notifyItemInserted(favList.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}