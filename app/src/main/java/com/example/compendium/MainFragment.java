package com.example.compendium;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.compendium.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.authorInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_FirstFragment_to_authorFragment);
            }
        });

        binding.basicInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_FirstFragment_to_basicInfoFragment);
            }
        });

        binding.charactersInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_FirstFragment_to_charactersFragment);
            }
        });

        binding.locationsInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_FirstFragment_to_locationsFragment);
            }
        });
        binding.triviasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_FirstFragment_to_triviasFragment);
            }
        });

        binding.appExtraOptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_FirstFragment_to_extraOptionsFragment);
            }
        });

        binding.appInfoButton.setOnClickListener(new View.OnClickListener() {
            final Context context = getContext();
            final CharSequence text = "Wersja aplikacji:"+BuildConfig.VERSION_NAME+" \n © Adam Bieszk 2023";

            final int duration = Toast.LENGTH_LONG;
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}