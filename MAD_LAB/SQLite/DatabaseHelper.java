package com.example.sqlitedatabasesavedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDB {
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "person_name";
    private static final String KEY_CELL = "_cell";
    private static final String DATABASE_NAME = "ContactsDB";
    private static final String TABLE_NAME = "ContactsTable";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;
    private final Context context;
    private DBHelper dbHelper;

    public ContactsDB(Context ctx) {
        context = ctx;
    }

    private static class DBHelper extends SQLiteOpenHelper {
        DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_NAME + " TEXT NOT NULL, "
                    + KEY_CELL + " TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public ContactsDB open() throws SQLException {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insert(String name, String cell) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_CELL, cell);
        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor fetch() {
        return db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_CELL},
                null, null, null, null, null);
    }

    public int update(String rowId, String name, String cell) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_CELL, cell);
        return db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]{rowId});
    }

    public int delete(String rowId) {
        return db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{rowId});
    }
}

