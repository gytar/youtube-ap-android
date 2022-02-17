package com.gytar.mybestyoutube.data.playlistitems;

import java.util.Date;

public class YoutubeItemContentDetails {
    private String videoId;
    private Date videoPublishedAt;

    public YoutubeItemContentDetails(String videoId, Date videoPublishedAt) {
        this.videoId = videoId;
        this.videoPublishedAt = videoPublishedAt;
    }

    public YoutubeItemContentDetails() {
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Date getVideoPublishedAt() {
        return videoPublishedAt;
    }

    public void setVideoPublishedAt(Date videoPublishedAt) {
        this.videoPublishedAt = videoPublishedAt;
    }

    @Override
    public String toString() {
        return "YoutubeItemContentDetails{" +
                "videoId='" + videoId + '\'' +
                ", videoPublishedAt=" + videoPublishedAt +
                '}';
    }
}
