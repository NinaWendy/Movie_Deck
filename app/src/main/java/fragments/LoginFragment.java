package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moringaschool.movie_deck.R;
import com.moringaschool.movie_deck.SearchActivity;
import com.moringaschool.movie_deck.databinding.FragmentLoginBinding;

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
//                   String user = username.getText().toString();
                Toast.makeText(getActivity(), "You are logged in!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                // intent.putExtra("user",user);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}