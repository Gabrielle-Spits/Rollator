package com.example.beroepsproduct4.database;

import android.provider.BaseColumns;

public class RollatorDataContract {

    private RollatorDataContract(){

    }
    public static class Zorgcentrums implements BaseColumns {
        public static final String TABLE_NAME = "zorgcentrums";
        public static final String Column_NAME_Afdeling= "afdeling";
        public static final String COLUMN_NAME_Zorgcentrum = "zorgcentrum";

    }


}
