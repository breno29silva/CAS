package com.example.cervejas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cervejas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchEmptyFragment extends Fragment {

    public SearchEmptyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_empty, container, false);
    }
}
