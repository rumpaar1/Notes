package com.example.rumpaar1.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Note> notes = new ArrayList<Note>();
    private ListView notesList;
    private ArrayAdapter<Note> noteArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newNote();
            }
        });
        notesList = (ListView) findViewById(R.id.notesList);
        noteArrayAdapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notes);
        notesList.setAdapter(noteArrayAdapter);
        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewNote(notes.get(i));
            }
        });
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

    public void newNote() {
        Intent intent = new Intent(this, AddNote.class);
        startActivity(intent);
    }

    @Override
    public void onNewIntent(Intent intent) {
        String title = intent.getStringExtra(AddNote.TITLE);
        String text = intent.getStringExtra(AddNote.TEXT);
        addNote(new Note(title, text));
        notesList.setAdapter(noteArrayAdapter);
    }

    private void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void viewNote(Note note) {
        Intent intent = new Intent(this, ViewNote.class);
        intent.putExtra("title", note.getName());
        intent.putExtra("text", note.getText());
        startActivity(intent);
    }

}
