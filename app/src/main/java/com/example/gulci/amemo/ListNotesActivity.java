package com.example.gulci.amemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ListNotesActivity extends AppCompatActivity {

    private List<Note> notesList = new ArrayList<Note>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        notesList.add(new Note("First note", "Sample note 1", new Date()));
        notesList.add(new Note("Second note", "Sample note 2", new Date()));
        notesList.add(new Note("Third note", "Sample note 3", new Date()));
        notesList.add(new Note("Fourth note", "Sample note 4", new Date()));
        notesList.add(new Note("Fifth note", "Sample note 5", new Date()));

        populateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        notesList.add(new Note("Dummy note", "Dummy note content", new Date()));

        populateList();

        return true;
    }

    private void populateList() {
        ListView notesListView = (ListView)findViewById(R.id.notesListView);

        List<String> noteTitles = new ArrayList<String>();

        for(Note note : notesList) {
            noteTitles.add(note.getTitle());
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>
                        (this, android.R.layout.simple_list_item_1, android.R.id.text1, noteTitles);

        notesListView.setAdapter(adapter);
    }
}
