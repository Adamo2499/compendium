package com.example.compendium;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExtraOptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExtraOptionsFragment extends Fragment {

    public ExtraOptionsFragment() {
        // Required empty public constructor
    }
    public static ExtraOptionsFragment newInstance(String param1, String param2) {
        ExtraOptionsFragment fragment = new ExtraOptionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extra_options, container, false);
    }
}