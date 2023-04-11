package com.example.compendium;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.compendium.databinding.FragmentAuthorBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AuthorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuthorFragment extends Fragment {

    private FragmentAuthorBinding binding;
    public AuthorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AuthorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorFragment newInstance(String param1, String param2) {
        AuthorFragment fragment = new AuthorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author, container, false);
        Button returnButton = (Button) view.findViewById(R.id.author_return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_authorFragment_to_FirstFragment);
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button homePageButton = view.findViewById(R.id.openMainPageButton);

        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jonathanocean.pl/"));
                getContext().startActivity(Intent.createChooser(intent, "Choose browser"));
            }
        });
    }

}