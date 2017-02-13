package com.example.alumno.pdm_p05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SongActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Song> list;

    ImageButton buttonNewSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent data = getIntent();


        list = data.getParcelableArrayListExtra("ListSong");

        this.listView = (ListView) findViewById(R.id.listView);

        List <Song> items = list;

        this.listView.setAdapter(new SongAdapter(this, items));



        // Pressess the add song button
        buttonNewSong = (ImageButton) findViewById(R.id.imageButtonAdd);
        buttonNewSong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SongActivity.this, AddSongActivity.class);


                intent.putExtra("cod", list.get(0).getAlbumCode());

                startActivityForResult(intent, 21);


            }
        });

    }

}
