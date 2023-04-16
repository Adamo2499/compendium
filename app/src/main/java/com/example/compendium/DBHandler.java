package com.example.compendium;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "kompendium";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "characters";
    // kolumny w tabeli
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String APPEARANCE_DESC_COL = "appearanceDesc";
    private static final String CHARACTER_DESC_COL = "characterDesc";
    private static final String RANK_COL = "rank";
    private static final String CONFLICT_SIDE_COL = "conflictSide";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE characters (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, appearanceDesc TEXT, characterDesc TEXT, rank TEXT, conflict_side TEXT)");

//        insertCharacter(sqLiteDatabase,1,"Lin","Wysoki brodacz","Porywczy zabijaka","Kapral","System Główny");
//        insertCharacter(sqLiteDatabase,2,"Antyvir","Wysoka, długowłosa brunetka","Chłodno myśli, ale jak przyjdzie co do czego to nie zawaha się wziąć za broń","Podchorąży","System Główny");
//        insertCharacter(sqLiteDatabase,3,"Dos","Zmienia formy po śmierci","Wierny druh, gotowy do poświęceń","Android", "System główny");
//        insertCharacter(sqLiteDatabase,4, "AISiri", "Zmienia wygląd kiedy ma na to ochotę", "Cichy i tajemniczy", "Wirus", "AISiri");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(sqLiteDatabase);
    }

    private static void insertCharacter(SQLiteDatabase db,int id, String name, String appearance, String character, String rank, String conflictSide) {
        ContentValues newCharacter = new ContentValues();
        newCharacter.put(ID_COL,id);
        newCharacter.put(NAME_COL,name);
        newCharacter.put(APPEARANCE_DESC_COL,appearance);
        newCharacter.put(CHARACTER_DESC_COL, character);
        newCharacter.put(RANK_COL,rank);
        newCharacter.put(CONFLICT_SIDE_COL,conflictSide);
        db.insert(TABLE_NAME,null,newCharacter);
    }

    public ArrayList<BookCharacter> readBookCharacters(){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor characters = db.rawQuery(selectQuery, null);

        ArrayList<BookCharacter> charactersArrayList = new ArrayList<>();
        if(characters.moveToFirst()){
            do {
                charactersArrayList.add(new BookCharacter(
                        characters.getString(1),
                        characters.getString(2),
                        characters.getString(3),
                        characters.getString(4),
                        characters.getString(5)));
            }
            while (characters.moveToNext());
        }
       characters.close();
        db.close();
        return charactersArrayList;
    }
}
