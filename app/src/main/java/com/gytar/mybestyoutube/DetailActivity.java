package com.gytar.mybestyoutube;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gytar.mybestyoutube.data.YoutubeVideo;
import com.gytar.mybestyoutube.data.dao.YoutubeVideoDao;

public class DetailActivity extends AppCompatActivity {

    private YoutubeVideo youtubeVideoDetail;
    private Context context;
    private Button showVideoOnYoutubeBtn;
    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvCategory;
    private TextView tvUrl;
    private Button deleteVideoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        youtubeVideoDetail = getIntent().getParcelableExtra("youtubeVideo");

        System.out.println(youtubeVideoDetail);

        showVideoOnYoutubeBtn = findViewById(R.id.show_on_youtube_btn);
        deleteVideoBtn = findViewById(R.id.delete_video_btn);


        tvTitle = findViewById(R.id.title_details_tv);
        tvDescription = findViewById(R.id.description_details_tv);
        tvCategory = findViewById(R.id.category_details_tv);
        tvUrl = findViewById(R.id.url_details_tv);

        // add text
        tvTitle.setText(youtubeVideoDetail.getTitle());
        tvDescription.setText(youtubeVideoDetail.getDescription());
        tvCategory.setText(youtubeVideoDetail.getCategory());
        tvUrl.setText(youtubeVideoDetail.getUrl());


        showVideoOnYoutubeBtn.setOnClickListener(view -> {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeVideoDetail.getUrl()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);
            } catch (Exception e) {
                Toast toast = Toast.makeText(context, "You don't have Youtube on your phone, please install it first ;)", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });


        deleteVideoBtn.setOnClickListener(view -> {
            YoutubeVideoDao youtubeVideoDao = new YoutubeVideoDao(getApplicationContext());
            youtubeVideoDao.delete(youtubeVideoDetail);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}