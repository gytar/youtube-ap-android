package com.gytar.mybestyoutube.data.playlistitems;

import com.gytar.mybestyoutube.data.playlistitems.PageInfo;
import com.gytar.mybestyoutube.data.playlistitems.YoutubeVideoItem;

import java.util.List;

public class YoutubeVideoRoot {
    private String kind;
    private String etag;
    private List<YoutubeVideoItem> items;
    private PageInfo pageInfo;

    public YoutubeVideoRoot(String kind, String etag, List<YoutubeVideoItem> items, PageInfo pageInfo) {
        this.kind = kind;
        this.etag = etag;
        this.items = items;
        this.pageInfo = pageInfo;
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

    public List<YoutubeVideoItem> getItems() {
        return items;
    }

    public void setItems(List<YoutubeVideoItem> items) {
        this.items = items;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}

