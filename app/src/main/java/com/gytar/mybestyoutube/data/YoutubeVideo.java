package com.gytar.mybestyoutube.data;

import android.os.Parcel;
import android.os.Parcelable;

public class YoutubeVideo implements Parcelable {


    public static final Creator<YoutubeVideo> CREATOR = new Creator<YoutubeVideo>() {
        @Override
        public YoutubeVideo createFromParcel(Parcel parcel) {
            return new YoutubeVideo(parcel);
        }

        @Override
        public YoutubeVideo[] newArray(int size) {
            return new YoutubeVideo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(url);
        parcel.writeString(category);
        parcel.writeString(channel);
        parcel.writeString(imageUrl);
    }

    private Long id;
    private String title;
    private String description;
    private String url;
    private String category;
    private String channel;
    private String imageUrl;

    public YoutubeVideo(Parcel parcel) {
        this.id = parcel.readLong();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.url = parcel.readString();
        this.category = parcel.readString();
        this.channel = parcel.readString();
        this.imageUrl = parcel.readString();
    }

    public YoutubeVideo() {}

    public YoutubeVideo(String title, String description, String url, String category, String channel, String imageUrl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
        this.channel = channel;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "YoutubeVideo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                ", channel='" + channel + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
