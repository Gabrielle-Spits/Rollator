package com.example.beroepsproduct4.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.beroepsproduct4.model.Oudergegevens;
import com.example.beroepsproduct4.model.Zorgcentrum;

import java.util.ArrayList;


public class DataDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Beroepsproduc4.db";

    private static final String SQL_CREATE_Zorgcentrum = "create table " + RollatorDataContract.Zorgcentrums.TABLE_NAME + " (" +
            RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling + " text NOT NULL ," +
            RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum + " text NOT NULL," +
            "PRIMARY KEY (" + RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling +"," + RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum + "))";

    private static final String SQL_CREATE_Ouderengegevens = "create table " + RollatorDataContract.Ouderengegevens.TABLE_NAME + "(" +
            RollatorDataContract.Ouderengegevens.Column_Name_Bsn + " text NOT NULL, " +
            RollatorDataContract.Ouderengegevens.Column_Name_Oudernaam+ " text NOT NULL, " +
            RollatorDataContract.Ouderengegevens.Column_NAME_Afdeling + " text NOT NULL, " +
            RollatorDataContract.Ouderengegevens.Column_NAME_Zorgcentrum + " text NOT NULL," +
            "PRIMARY KEY (" + RollatorDataContract.Ouderengegevens.Column_Name_Bsn + "),"+
            "FOREIGN KEY (" + RollatorDataContract.Ouderengegevens.Column_NAME_Afdeling  +","+ RollatorDataContract.Ouderengegevens.Column_NAME_Zorgcentrum + ") REFERENCES " + RollatorDataContract.Zorgcentrums.TABLE_NAME + " (" + RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling +","+ RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum+ "))";

    public DataDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }





    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_Zorgcentrum);
        db.execSQL(SQL_CREATE_Ouderengegevens);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }


    public long updatezorgcentrum(Zorgcentrum zorgcentrum1, Zorgcentrum oldzorgencentrum) {
        long result = 0;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(RollatorDataContract.Zorgcentrums.Column_NAME_Afdeling,zorgcentrum1.getAfdeling());
            values.put(RollatorDataContract.Zorgcentrums.COLUMN_NAME_Zorgcentrum,zorgcentrum1.getZorgcentrum());
            result = db.update(RollatorDataContract.Zorgcentrums.TABLE_NAME,values,"afdeling = ? and zorgcentrum =?",new String[]{oldzorgencentrum.getAfdeling(), oldzorgencentrum.getZorgcentrum()});
            System.out.println(result);
        }catch (SQLException se){
            se.getMessage();
        }
        return result;
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

    public long insertOudergegevens(Oudergegevens oudergegevens) {
        long result = 0;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(RollatorDataContract.Ouderengegevens.Column_Name_Bsn, oudergegevens.getBsn());
            values.put(RollatorDataContract.Ouderengegevens.Column_Name_Oudernaam, oudergegevens.getOudernaam());
            values.put(RollatorDataContract.Ouderengegevens.Column_NAME_Afdeling,oudergegevens.getZorgcentrum().getAfdeling());
            values.put(RollatorDataContract.Ouderengegevens.Column_NAME_Zorgcentrum,oudergegevens.getZorgcentrum().getZorgcentrum());
            result = db.insert(RollatorDataContract.Ouderengegevens.TABLE_NAME, null, values);
            System.out.println(result);
        }catch (SQLException sqlex) {
            sqlex.getMessage();
        }
        return result;
    }

    public long deleteZorgcentrum(Zorgcentrum zorgcentrum) {
        long result = 0;
        try {
            String strAfdeling = zorgcentrum.getAfdeling();
            String strZorgcentrum = zorgcentrum.getZorgcentrum();
            SQLiteDatabase db = this.getReadableDatabase();
            result = db.delete(RollatorDataContract.Zorgcentrums.TABLE_NAME,"afdeling=? and zorgcentrum =?", new String[]{strAfdeling,strZorgcentrum});

        }catch (SQLException se){

        }
        return result;
    }

    public ArrayList<Zorgcentrum> SpinnerZorgcentrum() {
        ArrayList<Zorgcentrum> zorgcentrums = new ArrayList();
        String sql = "select afdeling,zorgcentrum from zorgcentrums";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur_zorgcentrum = db.rawQuery(sql, null);

        if (cur_zorgcentrum.moveToFirst()) {
            do{
                Zorgcentrum zorgcentrum = new Zorgcentrum();
                zorgcentrum.setAfdeling(cur_zorgcentrum.getString(0));
                zorgcentrum.setZorgcentrum(cur_zorgcentrum.getString(1));
                zorgcentrums.add(zorgcentrum);
            } while (cur_zorgcentrum.moveToNext());
        }
            return zorgcentrums;
    }


    public long deleteOudergegevens(Oudergegevens oudergegevensdelete) {
        long result = 0;
        try {
            String strBsn = oudergegevensdelete.getBsn();
            SQLiteDatabase db = this.getReadableDatabase();
            result = db.delete(RollatorDataContract.Ouderengegevens.TABLE_NAME,"bsn=?", new String[]{strBsn});

        }catch (SQLException se){

        }
        return result;
    }

    public long updateOudergegevens(Oudergegevens oudergegevens) {
        long result = 0;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(RollatorDataContract.Ouderengegevens.Column_Name_Oudernaam,oudergegevens.getOudernaam());
            values.put(RollatorDataContract.Ouderengegevens.Column_NAME_Afdeling,oudergegevens.getZorgcentrum().getAfdeling());
            values.put(RollatorDataContract.Ouderengegevens.Column_NAME_Zorgcentrum,oudergegevens.getZorgcentrum().getZorgcentrum());
            result = db.update(RollatorDataContract.Ouderengegevens.TABLE_NAME,values,"bsn =?",new String[]{oudergegevens.getBsn()});
            System.out.println(result);
            System.out.println(values);
        }catch (SQLException se){
            se.getMessage();
        }
        return result;

    }
}

