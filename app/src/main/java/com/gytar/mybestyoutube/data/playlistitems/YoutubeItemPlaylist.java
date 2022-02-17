package com.gytar.mybestyoutube.data.playlistitems;

public class YoutubeItemPlaylist {
    private String kind;
    private String etag;
    private String id;
    private YoutubeItemSnippet snippet;
    private YoutubeItemContentDetails contentDetails;

    public YoutubeItemPlaylist(String kind, String etag, String id, YoutubeItemSnippet snippet, YoutubeItemContentDetails contentDetails) {
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
        this.contentDetails = contentDetails;
    }

    public YoutubeItemPlaylist() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YoutubeItemSnippet getSnippet() {
        return snippet;
    }

    public void setSnippet(YoutubeItemSnippet snippet) {
        this.snippet = snippet;
    }

    public YoutubeItemContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(YoutubeItemContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    @Override
    public String toString() {
        return "YoutubeItemPlaylist{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", id='" + id + '\'' +
                ", snippet=" + snippet +
                ", contentDetails=" + contentDetails +
                '}';
    }
}
