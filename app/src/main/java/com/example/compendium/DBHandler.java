package com.example.compendium;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

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

        sqLiteDatabase.execSQL("INSERT INTO characters VALUES(1,'Lin','Wysoki brodacz','Zabijaka','Kapral','System Główny')");
        sqLiteDatabase.execSQL("INSERT INTO characters VALUES(2,'Antyvir','Wysoka brunetka','Opanowana','Podchorąży','System Główny')");
        sqLiteDatabase.execSQL("INSERT INTO characters VALUES(3,'Dos','Robot','Wierny druh','Android','System Główny')");
        sqLiteDatabase.execSQL("INSERT INTO characters VALUES(4,'AISiri','Zmiennokształtny','Cichy i tajemniczy','Główny Wirus','AISiri')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }

    public ArrayList<BookCharacter> readBookCharacters(){
//        SQLiteDatabase db = openOrCreateDatabase("kompendium.db",null);
        SQLiteDatabase db = getReadableDatabase();

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
