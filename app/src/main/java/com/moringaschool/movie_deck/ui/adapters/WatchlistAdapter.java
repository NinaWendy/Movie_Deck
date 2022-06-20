package com.moringaschool.movie_deck.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.movie_deck.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WatchlistAdapter extends RecyclerView.Adapter<WatchlistAdapter.DataHolder>{
    private Context context;
    private ArrayList<String> watchList;

    public WatchlistAdapter(Context context, ArrayList<String> watchList) {
        this.context = context;
        this.watchList = watchList;
    }

    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom row layout
        View movieListView = inflater.inflate(R.layout.watchlist_row,parent,false);
        return new DataHolder(movieListView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
            holder.movieName.setText(watchList.get(position));
    }

    @Override
    public int getItemCount() {
        return watchList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.movieText)
        TextView movieName;
        private Context context;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }
}
