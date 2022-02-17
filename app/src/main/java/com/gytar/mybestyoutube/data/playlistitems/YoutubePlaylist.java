package com.gytar.mybestyoutube.data.playlistitems;

import com.gytar.mybestyoutube.data.playlistitems.YoutubeItemPlaylist;

import java.util.List;

public class YoutubePlaylist {
    private String kind;
    private String etag;
    private List<YoutubeItemPlaylist> items;

    public YoutubePlaylist(String kind, String etag, List<YoutubeItemPlaylist> items) {
        this.kind = kind;
        this.etag = etag;
        this.items = items;
    }

    public YoutubePlaylist() {}

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

    public List<YoutubeItemPlaylist> getItems() {
        return items;
    }

    public void setItems(List<YoutubeItemPlaylist> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "YoutubePlaylist{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", items=" + items +
                '}';
    }
}
