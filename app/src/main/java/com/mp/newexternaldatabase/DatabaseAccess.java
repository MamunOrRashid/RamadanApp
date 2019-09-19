package com.mp.newexternaldatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;

    Cursor c = null;

    //private constructor so that object creation from outside the class is avoided

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //to return the single instance of database
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //to open the database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    //closing the database connection
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    //now lets create a method to query and return the result from database
    //we will query for address by passing saheri ID
    public String getTime(String dateId) {

        String temp="0"+dateId;
        dateId = temp;

        c = db.rawQuery("select * from time where date = '" + dateId + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            for (int i = 0; i <= 7; i++) {
                buffer.append(c.getString(i) + ",");
            }
            buffer.append("\n");
        }
        return buffer.toString();
        /*
        String temp = "";
        while (c.moveToNext()) {
            for (int i = 0; i <= 7; i++) {
                temp += c.getString(i) + ",";
            }
            temp += "\n";
            //System.out.println("zero....."+c.getString(0));
            //System.out.println("\n\none....."+c.getString(1));
            //System.out.println("\n\ntwo....."+c.getString(2));
            //String time = c.getString(0);
            buffer.append("" + temp);
        }
        */
    }

}
