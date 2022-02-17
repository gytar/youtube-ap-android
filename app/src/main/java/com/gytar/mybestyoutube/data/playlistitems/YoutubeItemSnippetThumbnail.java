package com.gytar.mybestyoutube.data.playlistitems;

public class YoutubeItemSnippetThumbnail {
    private String url;
    private int width;
    private int height;

    public YoutubeItemSnippetThumbnail(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public YoutubeItemSnippetThumbnail() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "YoutubeItemSnippetThumbnail{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
