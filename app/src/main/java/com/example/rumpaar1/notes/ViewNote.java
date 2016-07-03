package com.example.rumpaar1.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ViewNote extends AppCompatActivity {
    private String title;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        title = getIntent().getStringExtra("title");
        text = getIntent().getStringExtra("text");
        ((TextView) findViewById(R.id.titleView)).setText(title);
        ((TextView) findViewById(R.id.textView)).setText(text);
    }
}
