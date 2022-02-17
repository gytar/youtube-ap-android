package com.gytar.mybestyoutube.data.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class YoutubeVideoDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "vide.db";

    public static final String YTVIDS_KEY = "id";
    public static final String YTVIDS_TITLE = "title";
    public static final String YTVIDS_DESCRIPTION = "description";
    public static final String YTVIDS_URL = "url";
    public static final String YTVIDS_CATEGORY = "category";
    public static final String YTVIDS_CHANNEL = "channel";
    public static final String YTVIDS_IMAGE_URL = "image";


    public static final String YTVIDS_TABLE_NAME = "YoutubeVideos";

    public static final int YTVIDS_KEY_COLUMN_INDEX = 0;
    public static final int YTVIDS_TITLE_COLUMN_INDEX = 1;
    public static final int YTVIDS_DESCRIPTION_COLUMN_INDEX = 2;
    public static final int YTVIDS_URL_COLUMN_INDEX = 3;
    public static final int YTVIDS_CATEGORY_COLUMN_INDEX = 4;
    public static final int YTVIDS_CHANNEL_COLUMN_INDEX = 5;
    public static final int YTVIDS_IMAGE_URL_COLUMN_INDEX = 6;

    private static final String YTVIDS_TABLE_CREATE =
            "CREATE TABLE " + YTVIDS_TABLE_NAME + " (" +
                    YTVIDS_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    YTVIDS_TITLE + " TEXT, " +
                    YTVIDS_DESCRIPTION + " TEXT, " +
                    YTVIDS_URL + " TEXT, " +
                    YTVIDS_CATEGORY + " TEXT," +
                    YTVIDS_CHANNEL + " TEXT, " +
                    YTVIDS_IMAGE_URL + " TEXT);";

    private static final  String YTVIDS_TABLE_DROP = "DROP TABLE IF EXISTS " + YTVIDS_TABLE_NAME + ";";

    public YoutubeVideoDBHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(YTVIDS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(YTVIDS_TABLE_DROP);
        onCreate(sqLiteDatabase);
    }
}
