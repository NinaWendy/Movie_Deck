package com.moringaschool.movie_deck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fragments.LoginFragment;
import fragments.SignupFragment;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.switchBtn)
    Button switchBtn;
    @BindView(R.id.loginText)
    TextView loginText;
    @BindView(R.id.signupTxt)
    TextView signupTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //display login fragment
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginText.setTextColor(Color.BLUE);
                signupTxt.setTextColor(Color.BLACK);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, LoginFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
        //Signup fragment
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupTxt.setTextColor(Color.BLUE);
                loginText.setTextColor(Color.BLACK);
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, SignupFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }
}