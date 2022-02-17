package com.gytar.mybestyoutube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gytar.mybestyoutube.data.YoutubeVideo;
import com.gytar.mybestyoutube.data.dao.YoutubeVideoDao;
import com.gytar.mybestyoutube.adapters.YoutubeVideoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<YoutubeVideo> youtubeVideos = new ArrayList<>();
    private YoutubeVideoDao youtubeVideoDao;
    private RecyclerView rvYtVideo;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);

        context = getApplicationContext();
        youtubeVideoDao = new YoutubeVideoDao(context);

        rvYtVideo = findViewById(R.id.rv_yt_video);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rvYtVideo.setHasFixedSize(true);
        rvYtVideo.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();

        YoutubeVideoAsyncTasks youtubeVideoAsyncTasks = new YoutubeVideoAsyncTasks();
        youtubeVideoAsyncTasks.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_youtube_video) {
            Intent intent = new Intent(getApplicationContext(), AddYoutubeActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.add_youtube_playlist) {
            Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public class YoutubeVideoAsyncTasks extends AsyncTask<String, Void, List<YoutubeVideo>> {

        @Override
        protected List<YoutubeVideo> doInBackground(String... strings) {
            List<YoutubeVideo> responseYoutubeVideo = new ArrayList<>();

            try {
                responseYoutubeVideo = youtubeVideoDao.list();
                for(YoutubeVideo video : responseYoutubeVideo) {
                    System.out.println("Image URL: " + video.getImageUrl());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return responseYoutubeVideo;
        }

        @Override
        protected void onPostExecute(List<YoutubeVideo> youtubeVideos) {
            refreshYoutubeVideos(youtubeVideos);
        }
    }

    private void refreshYoutubeVideos(List<YoutubeVideo> youtubeVideos) {
        YoutubeVideoAdapter youtubeVideoAdapter = new YoutubeVideoAdapter(youtubeVideos, item -> {
            Intent intent = new Intent(context, DetailActivity.class);

            intent.putExtra("youtubeVideo", item);
            startActivity(intent);
        });
        rvYtVideo.setAdapter(youtubeVideoAdapter);
    }
}