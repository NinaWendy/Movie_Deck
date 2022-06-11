package com.moringaschool.movie_deck.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.welcomeTxt)
    TextView welcome;
    TmdbApi client = TmdbClient.getClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String usr = intent.getStringExtra("user");
        welcome.setText("Welcome" + " " + usr);


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
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Something went wrong. Please check your Internet connection and try again later",
                                Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                });
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates an implicit Intent that will load a map to search for cinemas nearby
                Uri gmmIntentUri = Uri.parse("geo:-1.286389,36.817223?q=imax");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Import retrofit2 Call
                TmdbApi tmdbApi = TmdbClient.getClient();
                Call<Movies> responseCall = tmdbApi
                        .searchMovie(
                                Constants.TMDB_API_KEY,
                                "Action",
                                "1"
                        );
                responseCall.enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        Intent intent = new Intent(DashboardActivity.this,SearchActivity.class);
                        intent.putExtra("Response", response.body());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {
                        Log.e("Tag","Failed");
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Something went wrong. Please check your Internet connection and try again later",
                                Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                });
            }
        });

    }
}