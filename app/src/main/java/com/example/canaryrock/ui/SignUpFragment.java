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

import com.example.canaryrock.databinding.SignUpFragmentBinding;
import com.google.android.material.transition.MaterialFadeThrough;

public class SignUpFragment extends Fragment {
    //so .. in activity -> setContentView
    //BUT in a fragment -> return the view ?
    private SignUpFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new MaterialFadeThrough());
        setExitTransition(new MaterialFadeThrough());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
                             ){


        binding=SignUpFragmentBinding.inflate(inflater,container,false);
        //what's even going on ..
        //->INFLATE = reading the XML text -> BUILDING the actual layout objects
        //from it , the TextViews the LinearLayouts..

        //tool for that  = LayoutInflater
        //ViewGroup -> the PARENT of the view -> inflater needs it to compute layout width + height
        //Bundle ? -> saved previous state of the app OH rotating the app kills it remember..

        //ALSO.. inflating the layout -> gives the insante of the BIDNING !!

        binding.LoginLink.setOnClickListener(v->
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_signup_to_login));
            return binding.getRoot();
    }

    @Override
    public void onDestroyView(){
            super.onDestroyView();// the top level view (Scroll View in this case)
            // it gets that + reference to every child, weird but ok
            binding=null; // is this good practice ?
    }
}
