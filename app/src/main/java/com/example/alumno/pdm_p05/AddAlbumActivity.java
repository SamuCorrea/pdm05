package com.example.alumno.pdm_p05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddAlbumActivity extends AppCompatActivity {

    EditText editTextTitle;
    EditText editTextAuthor;
    DatePicker datePicker;

    private int albums;

    Album nAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);

    }


    public void addAlbum(View v){

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextAuthor = (EditText) findViewById(R.id.editTextAuthor);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        MyDbHelper aDbHelper = new MyDbHelper(this);

        albums = aDbHelper.lastALBUMBS();

        nAlbum = new Album((albums + 1),
                editTextTitle.getText().toString(),
                editTextAuthor.getText().toString(),
                datePicker.getDayOfMonth(),
                datePicker.getMonth(),
                datePicker.getYear(),
                "imagen"
        );

        aDbHelper.insertALBUM(nAlbum);

        /*Log.d("NUEVOS DATOS", (albums + 1) + " - " +
                editTextTitle.getText().toString() + " - " +
                editTextAuthor.getText().toString() + " - " +
                datePicker.getDayOfMonth() + " - " +
                datePicker.getMonth() + " - " +
                datePicker.getYear() + " - " +
                "imagen");*/

        finish();
    }




}
