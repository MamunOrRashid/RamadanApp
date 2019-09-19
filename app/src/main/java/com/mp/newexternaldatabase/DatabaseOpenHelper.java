package com.mp.newexternaldatabase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="testData";
    private static final int DATABASE_VERSION=1;




//    public DatabaseOpenHelper(Context context, String name, String storageDirectory, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, storageDirectory, factory, version);
//    }

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }
}
