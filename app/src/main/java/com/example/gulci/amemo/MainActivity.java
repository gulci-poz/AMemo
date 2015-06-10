package com.example.gulci.amemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private boolean isInEditMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button saveButton = (Button)findViewById(R.id.button_saveNote);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEditText = (EditText)findViewById(R.id.editText_titleEdit);
                EditText noteEditText = (EditText)findViewById(R.id.editText2_noteEdit);

                if(isInEditMode) {
                    isInEditMode = false;
                    saveButton.setText("Edit note");
                    titleEditText.setEnabled(false);
                    noteEditText.setEnabled(false);

                    TextView dateTextView = (TextView)findViewById(R.id.textView3_datePlaceholder);
                    DateFormat noteDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String noteDate = noteDateFormat.format(Calendar.getInstance().getTime());
                    dateTextView.setText(noteDate);
                }
                else {
                    isInEditMode = true;
                    saveButton.setText("Save note");
                    titleEditText.setEnabled(true);
                    noteEditText.setEnabled(true);
                }
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
}
