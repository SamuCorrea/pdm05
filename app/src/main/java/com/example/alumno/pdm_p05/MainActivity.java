package com.example.alumno.pdm_p05;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    // ATTRIBS


    ArrayList<Album> albumList = new ArrayList<Album>();
    ArrayList<Song> songList = new ArrayList<Song>();

    MyDbHelper aDbHelper;

    ImageButton buttonDetails;
    ImageButton buttonNewAlbum;

    ImageButton buttonNext;
    ImageButton buttonPrevious;

    ImageView frontImage;

    TextView textViewTitle, textViewAuthor, textViewDate;

    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INITIALIZES THE TEXTVIEWS

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewAuthor = (TextView) findViewById(R.id.textViewAuthor);
        textViewDate = (TextView) findViewById(R.id.textViewDate);

        // ALSO BUTTONS

        buttonNext = (ImageButton) findViewById(R.id.buttonNext);
        buttonPrevious = (ImageButton) findViewById(R.id.buttonPrevious);

        buttonPrevious.setEnabled(false);

        frontImage = (ImageView) findViewById(R.id.imageView);  // IMAGE VIEW


        aDbHelper = new MyDbHelper(this);   // DB HELPER




        // PRUEBA
        /*
        aDbHelper.deleteAllSONGS();
        aDbHelper.deleteAllALBUMS();
        */
        Album nAlbum = new Album (1, "Let It Be", "The Beatles", 8, 5, 1970, "letitbe");
        aDbHelper.insertALBUM(nAlbum);

        nAlbum = new Album (2, "Dark Side Of The Moon", "Pink Floyd", 1, 3, 1973, "darksideofthemoon");
        aDbHelper.insertALBUM(nAlbum);

        nAlbum = new Album (3, "Thriller", "Michael Jackson", 30, 11, 1982, "thriller");
        aDbHelper.insertALBUM(nAlbum);


        Song nSong = new Song (1, "Wanna Be Startin Something", 6, 3, 3);
        aDbHelper.insertSONG(nSong);
        nSong = new Song (2, "Baby Be Mine", 4, 20, 3);

        aDbHelper.insertSONG(nSong);

        albumList = aDbHelper.loadALBUMS();


        current = 0;

        showAlbum();

        listAlbumsInLog();
        listSongsInLog();

        // Pressess the details button
        buttonDetails = (ImageButton) findViewById(R.id.imageButtonDetails);
        buttonDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                songList = aDbHelper.loadSONGS(getCurrentAlbumId());  // CREATES DE SONGS LIST

                Intent intent = new Intent(MainActivity.this, SongActivity.class);

                intent.putExtra("ListSong", songList);

                intent.putExtra("albumCode", getCurrentAlbumId());

                startActivityForResult(intent, 11);


            }
        });



        // Pressess the new album button
        buttonNewAlbum = (ImageButton) findViewById(R.id.imageButtonAdd);
        buttonNewAlbum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this, AddAlbumActivity.class);


            startActivityForResult(intent, 12);

            }
        });


    }






    public void setFrontImage (String cad)                                                          // SET FRONT IMAGE
    {
        int id = getResources().getIdentifier(cad, "drawable", getPackageName());

        frontImage.setImageResource(id);

    }


    public void listAlbumsInLog () {                                                                // LOG

        for (int i = 0; i < albumList.size(); i++)
        {
            Log.d("title", albumList.get(i).getTitle());

        }
    }

    public void listSongsInLog () {

        for (int i = 0; i < songList.size(); i++)
        {
            Log.d("title", songList.get(i).getTitle());

        }
    }

    public void showAlbum () {                                                                      // SHOW ALBUM


        Album currentAlbum = albumList.get(current);

        textViewTitle.setText(currentAlbum.getTitle());
        textViewAuthor.setText(currentAlbum.getAuthor());
        textViewDate.setText(currentAlbum.getDd() + "/" + currentAlbum.getMm() + "/" + currentAlbum.getYyyy());

        setFrontImage(currentAlbum.getImage_id());

    }

    public void showNoData () {

        textViewTitle.setText("No data to show!");
        textViewAuthor.setText("");
        textViewDate.setText("");

        setFrontImage(null);
    }

    // NEXT && PREVIOUS                                                                             NEXT  && PREVIOUS CLICK
    public void next (View view) {

        current++;

        showAlbum();

        //LOG CONTROL

        Log.d("current", String.valueOf(current));
        Log.d("size", String.valueOf(albumList.size()));

        if (albumList.size() == current +1)    // if last
            buttonNext.setEnabled(false);

        if (buttonPrevious.isEnabled() == false)
            buttonPrevious.setEnabled(true);
    }

    public void previous(View view) {                                                               // PREVIOUS CLICK

        current--;

        showAlbum();

        // LOG CONTROL
        Log.d("current", String.valueOf(current));
        Log.d("size", String.valueOf(albumList.size()));

        if (0 == current)    // if first
            buttonPrevious.setEnabled(false);

        if (buttonNext.isEnabled() == false)
            buttonNext.setEnabled(true);
    }

    public int getCurrentAlbumId ()
    {
        return albumList.get(current).getCode();

    }

    public void deleteCurrentAlbum (View view)
    {
        int id = getCurrentAlbumId();

        albumList.remove(current);

        aDbHelper.deleteALBUM(id);


        if (current == 0)
        {
            showAlbum();
        }
        else
        {
            current--;
            showAlbum();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {                    // ON ACTIVITY RESULT
        super.onActivityResult(requestCode, resultCode, data);


        if ((resultCode == RESULT_OK) && (requestCode == 12)) { // ADDS ALBUM

            /*Album nAlbum = data.getParcelableExtra("nAlbum");

            albumList.add(nAlbum);
            */

            albumList = aDbHelper.loadALBUMS();
            current = albumList.size()-1;
            showAlbum();

        }
    }
}
