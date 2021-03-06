package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ihadzhi.jokerdisplayandroidlib.JokeDisplayActivity;
import com.ihadzhi.jokerlib.JokeTeller;

import static android.view.View.GONE;
import static com.ihadzhi.jokerdisplayandroidlib.JokeDisplayActivity.JOKE_PARAM;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void execute(String joke) {
                Intent jokeIntent = new Intent(MainActivity.this, JokeDisplayActivity.class);
                jokeIntent.putExtra(JOKE_PARAM, joke);
                progressBar.setVisibility(GONE);
                startActivity(jokeIntent);
            }
        }).execute(new Pair<Context, String>(this, "Nobody"));
    }


}
