package com.gytar.mybestyoutube.data.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO {
    protected SQLiteDatabase db = null;
    protected SQLiteOpenHelper baseHelper;

    public DAO(SQLiteOpenHelper baseHelper) {
        this.baseHelper = baseHelper;
    }

    public SQLiteDatabase open() {
        this.db =  baseHelper.getWritableDatabase();
        return this.db;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
