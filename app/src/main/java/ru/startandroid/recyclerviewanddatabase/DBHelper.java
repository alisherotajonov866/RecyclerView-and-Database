package ru.startandroid.recyclerviewanddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE Userdetails (name TEXT PRIMARY KEY, email TEXT, age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("DROP TABLE IF EXISTS Userdetails");
    }

    // Create:
    public Boolean insertUserdata(String name,String email,String age){

        // connect database
        SQLiteDatabase DB = this.getWritableDatabase();

        // write data in database
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("age",age);

        // checking connection
        long result = DB.insert("Userdetails",null,contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    // Read:
    public Cursor getData(){
        // connect database
        SQLiteDatabase DB = this.getWritableDatabase();

        // get data in database by cursor
        Cursor cursor = DB.rawQuery("SELECT * FROM Userdetails ",null);
        return cursor;
    }

}
