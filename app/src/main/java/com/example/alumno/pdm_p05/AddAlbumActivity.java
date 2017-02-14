package com.example.alumno.pdm_p05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddAlbumActivity extends AppCompatActivity {

    EditText editTextTitle;
    EditText editTextAuthor;
    DatePicker datePicker;

    private int albums;

    String imagen;

    Album nAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);


        // Pressess the details button
        ImageButton imageButtonAddImagen = (ImageButton) findViewById(R.id.imageButtonAddImagen);
        imageButtonAddImagen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddAlbumActivity.this, ImageActivity.class);

                startActivityForResult(intent, 31);


            }
        });

    }


    public void addAlbum(View v){

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextAuthor = (EditText) findViewById(R.id.editTextAuthor);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.setCalendarViewShown(false);

        MyDbHelper aDbHelper = new MyDbHelper(this);

        albums = aDbHelper.lastALBUMBS();

        nAlbum = new Album((albums + 1),
                editTextTitle.getText().toString(),
                editTextAuthor.getText().toString(),
                datePicker.getDayOfMonth(),
                datePicker.getMonth(),
                datePicker.getYear(),
                imagen
        );

        aDbHelper.insertALBUM(nAlbum);

        /*Log.d("NUEVOS DATOS", (albums + 1) + " - " +
                editTextTitle.getText().toString() + " - " +
                editTextAuthor.getText().toString() + " - " +
                datePicker.getDayOfMonth() + " - " +
                datePicker.getMonth() + " - " +
                datePicker.getYear() + " - " +
                "imagen");*/

        Intent data = new Intent();

        //data.putExtra("nAlbum", nAlbum);
        setResult(RESULT_OK, data);
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {                    // ON ACTIVITY RESULT
        super.onActivityResult(requestCode, resultCode, data);


        if ((resultCode == RESULT_OK) && (requestCode == 31)) { // ADDS IMAGE

            imagen = data.getStringExtra("image");

        }
    }


}
