package com.example.cervejas.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cervejas.R;
import com.example.cervejas.activity.SplashActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FailInternetFragment extends Fragment {

    public FailInternetFragment() {
        // Required empty public constructor
    }

    private Button btnTryConnection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fail_internet, container, false);

        btnTryConnection = view.findViewById(R.id.btnTryConnection);

        btnTryConnection.setOnClickListener(v -> startActivity(new Intent(getContext(), SplashActivity.class)));

        return view;
    }
}
