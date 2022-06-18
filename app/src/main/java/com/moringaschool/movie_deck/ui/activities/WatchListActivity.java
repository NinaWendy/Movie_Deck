package com.moringaschool.movie_deck.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.ui.adapters.WatchlistAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WatchListActivity extends AppCompatActivity {
     ArrayList<String> watchList;
     WatchlistAdapter watchlistAdapter;
     String data;
     @BindView(R.id.watchList)
    RecyclerView list;
     @BindView(R.id.movieAdd)
    EditText movieName;
     @BindView(R.id.addBtn)
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);
        ButterKnife.bind(this);
        watchList= new ArrayList<>();
        watchList.add("Squid Game");
        watchList.add("Money Heist");
        watchList.add("Interceptor");
        watchList.add("Don't Breathe 2");
        watchList.add("From");
        watchList.add("As The Crow Flies");
        watchList.add("Bay Watch");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WatchListActivity.this,LinearLayoutManager.VERTICAL,false);
        list.setLayoutManager(linearLayoutManager);
        watchlistAdapter = new WatchlistAdapter(WatchListActivity.this,watchList);
        list.setAdapter(watchlistAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(list);
    }
    public void save(View view){
        data = movieName.getText().toString();
        watchList.add(data);
        int position = watchList.indexOf(data);
        watchlistAdapter.notifyItemInserted(position);
        movieName.setText("");
    }
    String deletedMovie = null;
    List<String> archivedMovies = new ArrayList<>();
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP |ItemTouchHelper.DOWN,ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT ) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();

            Collections.swap(watchList,fromPosition,toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition,toPosition);
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    deletedMovie = watchList.get(position);
                    watchList.remove(position);
                    watchlistAdapter.notifyItemRemoved(position);
                    Snackbar.make(list,deletedMovie,Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    watchList.add(position,deletedMovie);
                                    watchlistAdapter.notifyItemInserted(position);
                                }
                            }).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    String movieName = watchList.get(position);
                    archivedMovies.add(movieName);
                    watchList.remove(position);
                    watchlistAdapter.notifyItemRemoved(position);
                    Snackbar.make(list,movieName + ", Archived",Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    archivedMovies.remove(archivedMovies.lastIndexOf(movieName));
                                    watchList.add(position,movieName);
                                    watchlistAdapter.notifyItemInserted(position);
                                }
                            }).show();
                    break;
            }
        }
    };
}