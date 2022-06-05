package com.moringaschool.movie_deck.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.Constants;
import com.moringaschool.movie_deck.models.Movies;
import com.moringaschool.movie_deck.network.clients.TmdbClient;
import com.moringaschool.movie_deck.network.interfaces.TmdbApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    @BindView(R.id.Home) CardView home;
    @BindView(R.id.Search) CardView search;
    @BindView(R.id.Profile) CardView profile;
    @BindView(R.id.Settings) CardView settings;
    TmdbApi client = TmdbClient.getClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Import retrofit2 Call
                Call<Movies> call = client.getResults(Constants.TMDB_API_KEY);
                call.enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("Response", response.body());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {

                    }
                });
            }
        });
    }
}