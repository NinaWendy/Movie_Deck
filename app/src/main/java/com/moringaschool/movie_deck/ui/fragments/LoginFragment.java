package com.moringaschool.movie_deck.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.databinding.FragmentLoginBinding;
import com.moringaschool.movie_deck.ui.activities.DashboardActivity;

public class LoginFragment extends Fragment {
    SharedPreferences sp;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLoginBinding binding;

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);

//        sp = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//        binding.checkBox.setChecked(false);
//        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.e("Test", "onCheckedChanged:Remember Me");
//                String usr = binding.username.getEditText().getText().toString();
//                String pass = binding.password.getEditText().getText().toString();
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("usrname",usr);
//                editor.putString("passwrd",pass);
//                editor.apply();
//            }
//        });

//        binding.loginButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String username = binding.usrName.getText().toString();
//                validateUser(username);
//                if (validateUser(username)) {
//                    Toast.makeText(getActivity(), "You are logged as " + username.toString(), Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
//                    intent.putExtra("user",username);
//                    startActivity(intent);
//                }
//            }
//            public Boolean validateUser(String user){
//                if(user.isEmpty() || user.length() <3){
//                    Toast.makeText(getActivity(), "invalid user name", Toast.LENGTH_LONG).show();
//                    return Boolean.FALSE;
//
//                }else
//                    return Boolean.TRUE;
//            }
//        });
//        SharedPreferences sP = getContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE);
//        String name = sP.getString("usrname","");
//        String passwad = sP.getString("passwrd","");
//        binding.usrName.setText(name);
//        binding.passwrd.setText(passwad);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}