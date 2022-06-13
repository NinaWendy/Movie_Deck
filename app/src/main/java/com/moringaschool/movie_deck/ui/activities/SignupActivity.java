package com.moringaschool.movie_deck.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.models.User;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @BindView(R.id.eMail)
    TextInputEditText email;
    @BindView(R.id.name)  TextInputEditText name;
    @BindView(R.id.phoneNumber)
    EditText phone;
    @BindView(R.id.passWd) EditText password;
    @BindView(R.id.cPassWd) EditText confirmPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.signupButton)
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
            String mail= Objects.requireNonNull(email.getText()).toString().trim();
            String fullName= Objects.requireNonNull(name.getText()).toString().trim();
            String phoneNumber= phone.getText().toString().trim();
            String passwd= password.getText().toString().trim();
            String cPasswd= confirmPassword.getText().toString().trim();

            if (fullName.isEmpty()){
                name.setError("Full name is required");
                name.requestFocus();
                return;
            }
            if (phoneNumber.isEmpty()){
                phone.setError("Phone number is required");
                phone.requestFocus();
                return;
            }
            if (phoneNumber.length() < 10 ){
                phone.setError("Invalid phone number");
                phone.requestFocus();
                return;
            }
            if (passwd.isEmpty()){
                password.setError("Password is required");
                password.requestFocus();
                return;
            }
            if (cPasswd.isEmpty()){
                confirmPassword.setError("Confirm password is required");
                confirmPassword.requestFocus();
                return;
            }
            if (mail.isEmpty()){
                email.setError("Email is required");
                email.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                email.setError("Please provide a valid email");
                email.requestFocus();
                return;
            }
            if (passwd.length() <6){
                password.setError("Min password length should be 6 characters");
                password.requestFocus();
                return;
            }
            if (!passwd.equals(cPasswd)){
                confirmPassword.setError("Does not match password");
                password.requestFocus();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(mail,passwd)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                User user= new User(mail,fullName,phoneNumber);
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    Toast.makeText(SignupActivity.this, "User has been registered successfully", Toast.LENGTH_SHORT).show();
                                                    progressBar.setVisibility(View.GONE);
                                                }else {
                                                    Toast.makeText(SignupActivity.this, "Failed to register! Try again!", Toast.LENGTH_SHORT).show();
                                                    progressBar.setVisibility(View.GONE);
                                                }
                                            }
                                        });
                            }else{
                                Toast.makeText(SignupActivity.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });

    }
}