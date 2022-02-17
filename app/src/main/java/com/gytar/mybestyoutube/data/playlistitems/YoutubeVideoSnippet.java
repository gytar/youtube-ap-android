package com.gytar.mybestyoutube.data.playlistitems;

import com.gytar.mybestyoutube.data.playlistitems.YoutubeItemLocalized;
import com.gytar.mybestyoutube.data.playlistitems.YoutubeItemSnippetThumbnail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class YoutubeVideoSnippet {
    private Date publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Map<String, YoutubeItemSnippetThumbnail> thumbnails = new HashMap<>();
    private String channelTitle;
    private String categoryId;
    private String liveBroadcastContent;
    private YoutubeItemLocalized localized;

    public YoutubeVideoSnippet(Date publishedAt, String channelId, String title, String description, Map<String, YoutubeItemSnippetThumbnail> thumbnails, String channelTitle, String categoryId, String liveBroadcastContent, YoutubeItemLocalized localized) {
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.title = title;
        this.description = description;
        this.thumbnails = thumbnails;
        this.channelTitle = channelTitle;
        this.categoryId = categoryId;
        this.liveBroadcastContent = liveBroadcastContent;
        this.localized = localized;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, YoutubeItemSnippetThumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Map<String, YoutubeItemSnippetThumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public YoutubeItemLocalized getLocalized() {
        return localized;
    }

    public void setLocalized(YoutubeItemLocalized localized) {
        this.localized = localized;
    }
}
