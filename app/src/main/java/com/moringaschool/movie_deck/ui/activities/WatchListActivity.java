package com.moringaschool.movie_deck.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.ui.adapters.WatchlistAdapter;

import java.util.ArrayList;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WatchListActivity.this,LinearLayoutManager.VERTICAL,false);
        list.setLayoutManager(linearLayoutManager);
        watchlistAdapter = new WatchlistAdapter(WatchListActivity.this,watchList);
        list.setAdapter(watchlistAdapter);
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
//        itemTouchHelper.attachToRecyclerView(list);
    }
    public void save(View view){
        data = movieName.getText().toString();
        watchList.add(data);
        int position = watchList.indexOf(data);
        watchlistAdapter.notifyItemInserted(position);
        movieName.setText("");
    }
//    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//        }
//    };
}