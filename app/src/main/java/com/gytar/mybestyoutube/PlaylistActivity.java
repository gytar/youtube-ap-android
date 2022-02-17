package com.gytar.mybestyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gytar.mybestyoutube.data.playlistitems.YoutubeItemPlaylist;
import com.gytar.mybestyoutube.data.playlistitems.YoutubePlaylist;
import com.gytar.mybestyoutube.data.YoutubeVideo;
import com.gytar.mybestyoutube.data.dao.YoutubeVideoDao;
import com.gytar.mybestyoutube.data.services.YoutubePlaylistService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaylistActivity extends AppCompatActivity {

    private Context context;
    private EditText etYoutubePlaylistId;
    private Button btnYoutubePlaylistSearch;
    private YoutubePlaylist youtubePlaylist = null;
    YoutubeVideoDao youtubeVideoDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        context = getApplicationContext();
        youtubeVideoDao = new YoutubeVideoDao(context);

        etYoutubePlaylistId = findViewById(R.id.playlist_id_et);
        btnYoutubePlaylistSearch = findViewById(R.id.playlist_search);

        btnYoutubePlaylistSearch.setOnClickListener(view -> {
            String playlistId = etYoutubePlaylistId.getText().toString();
            Toast.makeText(context, playlistId, Toast.LENGTH_SHORT).show();



            System.out.println("Youtubeplaylist = " + youtubePlaylist);


            YoutubePlaylistAsyncTask asyncTasks = new YoutubePlaylistAsyncTask(playlistId);
            asyncTasks.execute();
        });
    }


    public class YoutubePlaylistAsyncTask extends AsyncTask<String, Void, YoutubePlaylist> {

        public String playlistId;



        public YoutubePlaylistAsyncTask(String playlistId) {
            this.playlistId = playlistId;
        }

        @Override
        protected YoutubePlaylist doInBackground(String... strings) {

            YoutubePlaylistService youtubePlaylistService = new Retrofit.Builder()
                    .baseUrl(YoutubePlaylistService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(YoutubePlaylistService.class);


            youtubePlaylistService.getYoutubePlaylists(
                    YoutubePlaylistService.API_KEY,
                    "snippet,contentDetails",
                    playlistId,
                    20).enqueue(new Callback<YoutubePlaylist>() {
                @Override
                public void onResponse(Call<YoutubePlaylist> call, Response<YoutubePlaylist> response) {
                    youtubePlaylist = response.body();
                    Log.d("Async Task", "onResponse(), youtubePlaylist: " + youtubePlaylist);
                    for (YoutubeItemPlaylist item : youtubePlaylist.getItems()) {
                        YoutubeVideo video = new YoutubeVideo();
                        video.setUrl("https://www.youtube.com/watch?v=" + item.getContentDetails().getVideoId());
                        video.setTitle(item.getSnippet().getTitle());
                        video.setDescription(item.getSnippet().getDescription());
                        video.setCategory("");
                        video.setChannel(video.getChannel());
                        if (item.getSnippet().getThumbnails() != null && item.getSnippet().getThumbnails().size() > 0) {
                            video.setImageUrl(item.getSnippet().getThumbnails().get("default").getUrl());
                        } else {
                            video.setImageUrl("https://3oo0b421bpxh3iw1eo1um51o-wpengine.netdna-ssl.com/wp-content/themes/truemag-child/images/hqdefault.jpg");
                        }

                        youtubeVideoDao.insert(video);
                    }
                }

                @Override
                public void onFailure(Call<YoutubePlaylist> call, Throwable t) {
                }
            });


            return youtubePlaylist;
        }
    }
}