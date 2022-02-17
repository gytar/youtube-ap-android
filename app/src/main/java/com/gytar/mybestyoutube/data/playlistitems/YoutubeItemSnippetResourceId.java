package com.gytar.mybestyoutube.data.playlistitems;

public class YoutubeItemSnippetResourceId {
    private String kind;
    private String videoId;

    public YoutubeItemSnippetResourceId(String kind, String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    public YoutubeItemSnippetResourceId() {}

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "YoutubeItemSnippetResourceId{" +
                "kind='" + kind + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
