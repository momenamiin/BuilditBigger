package com.project.udacity.androidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        textView = findViewById(R.id.Joke);
        Intent intent = getIntent() ;
        String Joke = intent.getStringExtra("Joke");
        textView.setText(Joke);
    }
}
