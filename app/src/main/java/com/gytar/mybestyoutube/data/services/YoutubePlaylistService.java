package com.gytar.mybestyoutube.data.services;

import com.gytar.mybestyoutube.data.playlistitems.YoutubePlaylist;
import com.gytar.mybestyoutube.data.playlistitems.YoutubeVideoRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubePlaylistService {
    String ENDPOINT = "https://www.googleapis.com/youtube/v3/";
    String API_KEY = "AIzaSyDph78KGssq5ZqaEEIndeRbEpYsnEpzUJk";

    @GET("playlistItems")
    Call<YoutubePlaylist> getYoutubePlaylists(
            @Query("key") String key,
            @Query("part") String part,
            @Query("playlistId") String playlistId,
            @Query("maxResults") int maxResults);

    @GET("videos")
    Call<YoutubeVideoRoot> getYoutubeVideo(
            @Query("key") String key,
            @Query("part") String part,
            @Query("videoId") String videoId,
            @Query("maxResults") int maxResult);
}
