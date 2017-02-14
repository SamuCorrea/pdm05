package com.example.alumno.pdm_p05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SongActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Song> songList;

    int albumCode;
    ImageButton buttonNewSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent data = getIntent();


        songList = data.getParcelableArrayListExtra("ListSong");
        albumCode = data.getIntExtra("albumCode", 0);

        this.listView = (ListView) findViewById(R.id.listView);

        List <Song> items = songList;

        this.listView.setAdapter(new SongAdapter(this, items));



        // Pressess the add song button
        buttonNewSong = (ImageButton) findViewById(R.id.imageButtonAdd);
        buttonNewSong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SongActivity.this, AddSongActivity.class);


                intent.putExtra("albumCode", albumCode);

                startActivityForResult(intent, 21);


            }
        });

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {                    // ON ACTIVITY RESULT
        super.onActivityResult(requestCode, resultCode, data);


        if ((resultCode == RESULT_OK) && (requestCode == 21)) { // ADDS NEW SONG

            Song nSong = data.getParcelableExtra("nSong");

            MyDbHelper aDbHelper = new MyDbHelper(this);

            songList.add(nSong);

            this.listView.setAdapter(new SongAdapter(this, songList));
        }
    }
}
