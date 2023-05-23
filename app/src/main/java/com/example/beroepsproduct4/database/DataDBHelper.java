package com.example.beroepsproduct4.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.beroepsproduct4.model.Zorgcentrum;


public class DataDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Beroepsproduc4.db";

    private static final String SQL_CREATE_Zorgcentrum = "create table " + RollatorDataContract.Zorgcentrums.TABLE_NAME + " (" +
            RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling + " text NOT NULL ," +
            RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum + " text NOT NULL," +
            "PRIMARY KEY (" + RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling +"," + RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum + "))";


    public DataDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public long insertZorcentrum(Zorgcentrum zorgcentrum) {
        long result = 0;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling, zorgcentrum.getAfdeling());
            values.put(RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum, zorgcentrum.getZorgcentrum());
            result = db.insert(RollatorDataContract.Zorgcentrums.TABLE_NAME, null, values);
            System.out.println(result);

        } catch (SQLException sqlex) {
            sqlex.getMessage();
        }
        return result;
    }



    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_Zorgcentrum);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }



}

