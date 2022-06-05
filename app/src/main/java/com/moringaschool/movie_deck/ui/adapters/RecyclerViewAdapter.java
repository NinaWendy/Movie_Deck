package com.moringaschool.movie_deck.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Constants;
import com.moringaschool.movie_deck.models.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Result> mMovies;
    private Context mContext;
    // Pass in the RecyclerModelClass array into the constructor
    public RecyclerViewAdapter(Context context, List<Result> movies) {
        mContext =context;
        mMovies= movies;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(mContext);
        // Inflate the custom row layout
        View movieView = inflater.inflate(R.layout.custom_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(movieView);
       return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.mMovieTitle.setText(mMovies.get(position).getOriginalName());
       holder.mMovieYear.setText(mMovies.get(position).getFirstAirDate());
       holder.mRating.setText("Rating: " + mMovies.get(position).getVoteAverage() + "/10");

        Glide.with(mContext)
                .load(Constants.IMG_BASE_URL+mMovies.get(position).getPosterPath())
                .into(holder.mMovieImage);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    //View holder inner class
    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.movieImgRecycler)
        ImageView mMovieImage;
        @BindView(R.id.mvTitle)
        TextView mMovieTitle;
        @BindView(R.id.year)
        TextView mMovieYear;
        @BindView(R.id.rating)
        TextView mRating;
        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }



}
