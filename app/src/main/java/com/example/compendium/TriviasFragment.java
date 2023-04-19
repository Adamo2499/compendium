package com.example.compendium;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.compendium.databinding.FragmentTriviasBinding;

public class TriviasFragment extends Fragment {

    private FragmentTriviasBinding binding;
    private boolean isBound = false;
    Button startButton, stopButton;

    public TriviasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trivias, container, false);
        Button returnButton = view.findViewById(R.id.trivias_return_button);
        returnButton.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_triviasFragment_to_FirstFragment));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startButton = getView().findViewById(R.id.startAISiriButton);
        stopButton = getView().findViewById(R.id.stopAISiriButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().startService(new Intent(getActivity(),AISiriService.class));
               startButton.setVisibility(View.INVISIBLE);
               stopButton.setVisibility(View.VISIBLE);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(), AISiriService.class));
                stopButton.setVisibility(View.INVISIBLE);
                startButton.setVisibility(View.VISIBLE);
            }
        });
    }
}