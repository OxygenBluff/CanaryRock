package com.example.canaryrock.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.canaryrock.R;
import com.example.canaryrock.databinding.LogInFragmentBinding;
import com.google.android.material.transition.MaterialFadeThrough;

public class LogInFragment extends Fragment {

    private LogInFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new MaterialFadeThrough());
        setExitTransition(new MaterialFadeThrough());
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
            ){

        binding = LogInFragmentBinding.inflate(inflater,container,false);

        binding.SignupLink.setOnClickListener(v->
                        NavHostFragment.findNavController(this)
                                .navigate(R.id.action_login_to_signUp));
        //.navigate takes the ACTION ID from nav_graph.xml omg..

        return binding.getRoot();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding=null;
    }
}
