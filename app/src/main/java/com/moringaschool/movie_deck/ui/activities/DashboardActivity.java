package com.moringaschool.movie_deck.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moringaschool.movie_deck.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {
    @BindView(R.id.Home) CardView home;
    @BindView(R.id.Search) CardView search;
    @BindView(R.id.Profile) CardView profile;
    @BindView(R.id.Settings) CardView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}