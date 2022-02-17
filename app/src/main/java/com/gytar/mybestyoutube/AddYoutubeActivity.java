package com.gytar.mybestyoutube;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gytar.mybestyoutube.data.Categories;
import com.gytar.mybestyoutube.data.YoutubeVideo;
import com.gytar.mybestyoutube.data.dao.YoutubeVideoDao;

import java.util.ArrayList;
import java.util.List;

public class AddYoutubeActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private EditText titleEdit;
    private EditText descriptionEdit;
    private EditText urlEdit;
    private EditText channelEt;
    private Button addBtn;
    private Button cancelBtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        context = getApplicationContext();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        categorySpinner = findViewById(R.id.spr_category);
        addBtn = findViewById(R.id.add_btn);
        cancelBtn = findViewById(R.id.cancel_btn);
        titleEdit = findViewById(R.id.title_edt);
        descriptionEdit = findViewById(R.id.desc_edt);
        urlEdit = findViewById(R.id.url_edt);
        channelEt = findViewById(R.id.channel_edt);

        List<String> categories = new ArrayList<>();
        for (Categories category : Categories.values()) {
            categories.add(category.getLabel());
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, categories);
        categorySpinner.setAdapter(spinnerArrayAdapter);

        addBtn.setOnClickListener(view -> {
            String title = titleEdit.getText().toString().trim();
            String description = descriptionEdit.getText().toString().trim();
            String url = urlEdit.getText().toString().trim();
            String category = categorySpinner.getSelectedItem().toString();
            String channel = channelEt.getText().toString().trim();

            if (title.length() > 5 && description.length() > 5 && url.length() > 5) {
                YoutubeVideo youtubeVideo = new YoutubeVideo(title, description, url, category, channel, "");
                YoutubeVideoDao youtubeVideoDao = new YoutubeVideoDao(context);
                youtubeVideoDao.insert(youtubeVideo);
                finish();
            } else {
                Toast toast = Toast.makeText(context, "You should input at least 5 characters", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

        cancelBtn.setOnClickListener(view -> finish());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}