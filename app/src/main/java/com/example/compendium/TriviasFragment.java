package com.example.compendium;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.compendium.databinding.FragmentTriviasBinding;

import org.w3c.dom.Text;

public class TriviasFragment extends Fragment {

    private FragmentTriviasBinding binding;

//    ListView trivasList;
//    String trivias[] = {"Trivia1","Trivia2","Trivia3"};


    public TriviasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentTriviasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button startAISiri = (Button) view.findViewById(R.id.start_aisiri_button);
        Button stopAISiri = (Button) view.findViewById(R.id.stop_aisiri_button);
        Intent AISiriIntent = new Intent(String.valueOf(AISiriService.class));

//        if (binding != null && binding.startAisiriButton != null) {
//
//        } else {
//            Log.e(TAG, "Binding object or startAisiriButton is null");
//        }

        binding.startAisiriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "AI Siri Start button clicked!");
                startAISiri.setVisibility(View.INVISIBLE);
                startActivity(AISiriIntent);
                stopAISiri.setVisibility(View.VISIBLE);
            }
        });

        binding.stopAisiriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "AI Siri Stop button clicked!");
                getActivity().finish();
                startAISiri.setVisibility(View.VISIBLE);
                stopAISiri.setVisibility(View.INVISIBLE);
            }
        });
    }
}