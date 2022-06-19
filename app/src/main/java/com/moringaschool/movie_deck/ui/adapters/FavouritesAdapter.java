package com.moringaschool.movie_deck.ui.adapters;

import android.content.Context;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Favourite;
import com.moringaschool.movie_deck.models.Result;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> favList;

    public FavouritesAdapter(Context context, ArrayList<String> favList) {
        this.context = context;
        this.favList = favList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fav_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            String favourite = favList.get(position);
            holder.title.setText(favourite);
    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.favTxt);
        }
    }
}
