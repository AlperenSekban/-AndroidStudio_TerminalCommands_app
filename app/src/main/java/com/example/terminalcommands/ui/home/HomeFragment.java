package com.example.terminalcommands.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.terminalcommands.CategoriesFragment;
import com.example.terminalcommands.R;

public class HomeFragment extends Fragment{

    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_home_frameLayout,new CategoriesFragment(),"recrcylerview")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


        return view;
    }






}