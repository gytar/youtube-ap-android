package com.gytar.mybestyoutube.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.gytar.mybestyoutube.data.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

public class YoutubeVideoDao extends DAO {

    public YoutubeVideoDao(Context context) {
        super(new YoutubeVideoDBHelper(context));
    }

    public YoutubeVideo find(Long id) {
        YoutubeVideo youtubeVideo = null;
        open();
        Cursor cursor = db.rawQuery("select * from " + YoutubeVideoDBHelper.YTVIDS_TABLE_NAME +
                        " where " + YoutubeVideoDBHelper.YTVIDS_KEY + " = ?",
                new String[] { String.valueOf(id) });

        if (cursor != null && cursor.moveToFirst()) youtubeVideo = this.getYoutubeVideoWithCursor(cursor);

        close();
        return youtubeVideo;
    }

    public List<YoutubeVideo> list() {
        List<YoutubeVideo> youtubeVideos = new ArrayList<>();
        open();

        Cursor cursor = db.rawQuery("SELECT * FROM " + YoutubeVideoDBHelper.YTVIDS_TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                youtubeVideos.add(this.getYoutubeVideoWithCursor(cursor));
                cursor.moveToNext();
            }
            cursor.close();
        }
        close();
        return youtubeVideos;
    }

    public YoutubeVideo insert(YoutubeVideo youtubeVideo) {
        open();

        ContentValues values = new ContentValues();
        values.put(YoutubeVideoDBHelper.YTVIDS_TITLE, youtubeVideo.getTitle());
        values.put(YoutubeVideoDBHelper.YTVIDS_DESCRIPTION, youtubeVideo.getDescription());
        values.put(YoutubeVideoDBHelper.YTVIDS_URL, youtubeVideo.getUrl());
        values.put(YoutubeVideoDBHelper.YTVIDS_CATEGORY, youtubeVideo.getCategory());
        values.put(YoutubeVideoDBHelper.YTVIDS_CHANNEL, youtubeVideo.getChannel());
        values.put(YoutubeVideoDBHelper.YTVIDS_IMAGE_URL, youtubeVideo.getImageUrl());

        Long id = db.insert(YoutubeVideoDBHelper.YTVIDS_TABLE_NAME, null, values);
        youtubeVideo.setId(id);

        close();

        return youtubeVideo;
    }

    public void delete(YoutubeVideo youtubeVideo) {
        open();
        db.delete(YoutubeVideoDBHelper.YTVIDS_TABLE_NAME, YoutubeVideoDBHelper.YTVIDS_KEY + " = ?",
                    new String[] {String.valueOf(youtubeVideo.getId())});
        close();
    }

    private YoutubeVideo getYoutubeVideoWithCursor(Cursor cursor) {
        YoutubeVideo youtubeVideo = new YoutubeVideo();
        youtubeVideo.setId(cursor.getLong(YoutubeVideoDBHelper.YTVIDS_KEY_COLUMN_INDEX));
        youtubeVideo.setTitle(cursor.getString(YoutubeVideoDBHelper.YTVIDS_TITLE_COLUMN_INDEX));
        youtubeVideo.setDescription(cursor.getString(YoutubeVideoDBHelper.YTVIDS_DESCRIPTION_COLUMN_INDEX));
        youtubeVideo.setUrl(cursor.getString(YoutubeVideoDBHelper.YTVIDS_URL_COLUMN_INDEX));
        youtubeVideo.setCategory(cursor.getString(YoutubeVideoDBHelper.YTVIDS_CATEGORY_COLUMN_INDEX));
        youtubeVideo.setChannel(cursor.getString(YoutubeVideoDBHelper.YTVIDS_CHANNEL_COLUMN_INDEX));
        youtubeVideo.setImageUrl(cursor.getString(YoutubeVideoDBHelper.YTVIDS_IMAGE_URL_COLUMN_INDEX));

        return youtubeVideo;
    }
}
