package com.example.compendium;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharactersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharactersFragment extends Fragment {

    private SQLiteDatabase db;
    private DBHandler dbHandler;
    private RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    ArrayList<BookCharacter> bookCharacters;

    public CharactersFragment() {
        // Required empty public constructor
    }

    public static CharactersFragment newInstance() {
        CharactersFragment fragment = new CharactersFragment();
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
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        Button returnButton = (Button) view.findViewById(R.id.characters_return_button);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_charactersFragment_to_FirstFragment);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showCharacters();
    }

    public void showCharacters(){
        dbHandler = new DBHandler(getContext());
        bookCharacters = dbHandler.readBookCharacters();
        TextView character1TextView = getView().findViewById(R.id.charactersDescriptions);
        String characterDesc = "";
        for (int i = 0; i < bookCharacters.size(); i++) {
            BookCharacter bookCharacter = bookCharacters.get(i);
            characterDesc += "Imię: "+bookCharacter.getName()+"\n";
            characterDesc += "Wygląd: "+bookCharacter.getAppearanceDesc()+"\n";
            characterDesc += "Zachowanie: "+bookCharacter.getCharacterDesc()+"\n";
            characterDesc += "Stopień: "+bookCharacter.getRank()+"\n";
            characterDesc += "Strona konfliktu: "+bookCharacter.getConflictSide()+"\n";
            characterDesc += "\n";
        }
//        character1TextView.setText(bookCharacters.get(0).getName());
        character1TextView.setText(characterDesc);


    }
}