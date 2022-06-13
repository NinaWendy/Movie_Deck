package com.moringaschool.movie_deck.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Constants;
import com.moringaschool.movie_deck.models.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.MyHolder>{
    private List<Result> mMovies;

    private Context mContext;
    // Pass in the RecyclerModelClass array into the constructor
    public GridRecyclerAdapter(Context context, List<Result> movies) {
        mContext =context;
        mMovies= movies;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        // Inflate the custom row layout
        View movieView = inflater.inflate(R.layout.card_item,parent,false);
        MyHolder myHolder = new MyHolder(movieView);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.cardTxt.setText(mMovies.get(position).getOriginalTitle());

        Glide.with(mContext)
                .load(Constants.IMG_BASE_URL+mMovies.get(position).getPosterPath())
                .into(holder.cardImg);


    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.cardImg)
        ImageView cardImg;
        @BindView(R.id.cardTxt)
        TextView cardTxt;
        private Context context;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }
}

