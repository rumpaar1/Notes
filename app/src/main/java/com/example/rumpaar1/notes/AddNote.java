package com.example.rumpaar1.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNote extends AppCompatActivity {
    public static final String TITLE = "com.example.rumpaar1.notes.AddNote.TITLE";
    public static final String TEXT = "com.example.rumpaar1.notes.AddNote.TEXT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }

    public void submit(View view) {
        String title = ((EditText)findViewById(R.id.name)).getText().toString();
        String text = ((EditText)findViewById(R.id.note)).getText().toString();
        Note note = new Note(title, text);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(this.TITLE, note.getName());
        intent.putExtra(this.TEXT, note.getText());
        startActivity(intent);
        finish();
    }

}
