package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

public class MainActivityFragment extends Fragment {



    public MainActivityFragment() {
    }

    private static ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = root.findViewById(R.id.progress_bar_waiting_for_joke);
        progressBar.setVisibility(View.INVISIBLE);

        return root;
    }

    static void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    static void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }
}
