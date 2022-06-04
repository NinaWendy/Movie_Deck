package com.moringaschool.movie_deck.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.databinding.FragmentLoginBinding;
import com.moringaschool.movie_deck.ui.activities.DashboardActivity;

public class LoginFragment extends Fragment {
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLoginBinding binding;

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = binding.username.getEditText().getText().toString();
                validateUser(username);
                if (validateUser(username)) {
                    Toast.makeText(getActivity(), "You are logged as " + username.toString(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
                    startActivity(intent);
                }
            }
            public Boolean validateUser(String user){
                if(user.isEmpty() || user.length() <2){

                    Toast.makeText(getActivity(), "invalid user name", Toast.LENGTH_LONG).show();
                    return Boolean.FALSE;

                }else
                    return Boolean.TRUE;
            }
        });
        // Inflate the layout for this fragment


        return binding.getRoot();
    }
}