package com.example.compendium;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExtrasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExtrasFragment extends Fragment {

    public ExtrasFragment() {
        // Required empty public constructor
    }
    public static ExtrasFragment newInstance(String param1, String param2) {
        ExtrasFragment fragment = new ExtrasFragment();
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
        View view = inflater.inflate(R.layout.fragment_extras, container, false);
        Button returnButton = (Button) view.findViewById(R.id.extras_return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_extraOptionsFragment_to_FirstFragment);
            }
        });
        return view;
    }
}