package com.example.nirvana;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";


    // creating a constructor for our database handler.
    public dbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT)";
        db.execSQL(query);
    }

    public void addUser(String username, String password) {


        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a variable for content values.
        ContentValues values = new ContentValues();

        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USERNAME};
        String whereclause = COLUMN_USERNAME + "=?";
        String[] whereargs = {username};
        Cursor cursor = db.query(TABLE_NAME, columns, whereclause, whereargs, null, null, null);

        boolean usernameExists = cursor.moveToFirst();

        cursor.close();
        return usernameExists;
    }


    public boolean checkUserAndPassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USERNAME, COLUMN_PASSWORD};
        String whereclause = COLUMN_USERNAME + "=?";
        String[] whereargs = {username};
        Cursor cursor = db.query(TABLE_NAME, columns, whereclause, whereargs, null, null, null);

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String storedUsername = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            @SuppressLint("Range") String storedPassword = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                cursor.close();
                return true; // Username and password match
            }
        }

        cursor.close();
        return false; // Username and password do not match or user not found
    }

    public int updateUserCredentials(String oldUsername, String newUsername, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USERNAME, newUsername);
        values.put(COLUMN_PASSWORD, newPassword);

        String whereClause = COLUMN_USERNAME + "=?";
        String[] whereArgs = {oldUsername};

        try {
            int rowsAffected = db.update(TABLE_NAME, values, whereClause, whereArgs);
            db.close();
            return rowsAffected;
        } catch (Exception e) {
            Log.e("UpdateError", "Error updating credentials: " + e.getMessage());
            return -1;  // Return a value indicating an error.
        }
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
