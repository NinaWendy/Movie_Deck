package com.moringaschool.movie_deck.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.movie_deck.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.switchBtn)
    Button switchBtn;
    @BindView(R.id.usrEmail)
    TextInputEditText loginEmail;
    @BindView(R.id.loginPasswrd)
    TextInputEditText loginPassword;
    @BindView(R.id.signUpTxt)
    TextView signupTxt;
    @BindView(R.id.loginButton)
    Button login;
    @BindView(R.id.loginProgressBar)
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    SharedPreferences sp;
    @BindView(R.id.checkBox)
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        sp = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(5)
                        .playOn(findViewById(R.id.usrEmail));
                userLogin();
            }
        });
        checkBox.setChecked(false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("Test", "onCheckedChanged:Remember Me");
                String usr = Objects.requireNonNull(loginEmail.getText()).toString();
                String pass = Objects.requireNonNull(loginPassword.getText()).toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("usrname",usr);
                editor.putString("passwrd",pass);
                editor.apply();
            }
        });
        SharedPreferences sP = getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        String useremail = sP.getString("usrname","");
        String passwad = sP.getString("passwrd","");
        loginEmail.setText(useremail);
        loginPassword.setText(passwad);
    }

    private void userLogin() {
        String usrEmail = Objects.requireNonNull(loginEmail.getText()).toString().trim();
        String usrPassword= Objects.requireNonNull(loginPassword.getText()).toString().trim();

        if (usrPassword.isEmpty()){
            loginPassword.setError("Password is required");
            loginPassword.requestFocus();
            return;
        }
        if (usrEmail.isEmpty()){
            loginEmail.setError("Email is required");
            loginEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(usrEmail).matches()){
            loginEmail.setError("Please provide a valid email");
            loginEmail.requestFocus();
            return;
        }
        if (usrPassword.length() <6){
            loginPassword.setError("Min password length should be 6 characters");
            loginPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(usrEmail,usrPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                        progressBar.setVisibility(View.GONE);
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra("user",usrEmail);
                        startActivity(intent);


                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

//Further Implementation
//display login fragment
//        loginText.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        loginText.setTextColor(Color.BLUE);
//        signupTxt.setTextColor(Color.BLACK);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//        .replace(R.id.fragmentContainer, LoginFragment.class, null)
//        .setReorderingAllowed(true)
//        .addToBackStack("name")
//        .commit();
//        }
//        });
//        //Signup fragment
//        signupTxt.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        signupTxt.setTextColor(Color.BLUE);
//        loginText.setTextColor(Color.BLACK);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//        .replace(R.id.fragmentContainer, SignupFragment.class, null)
//        .setReorderingAllowed(true)
//        .addToBackStack("name")
//        .commit();
//        }
//        });