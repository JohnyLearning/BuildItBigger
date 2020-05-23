package com.ihadzhi.jokerdisplayandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_PARAM = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        TextView jokeContent = findViewById(R.id.joke_content);
        if (getIntent() != null) {
            jokeContent.setText(getIntent().getStringExtra(JOKE_PARAM));
        }
    }
}
