package com.example.alumno.pdm_p05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddSongActivity extends AppCompatActivity {


    EditText editTextTitle;

    private int songs;
    private int codAlbum;

    NumberPicker numberPickerMm, numberPickerSs;

    String[] nums;

    Song nSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);

        Intent data = getIntent();

        numberPickerMm = numPicker((NumberPicker)findViewById(R.id.numberPickerMm));
        numberPickerSs = numPicker((NumberPicker)findViewById(R.id.numberPickerSs));

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);

        codAlbum = data.getIntExtra("cod", 1);

    }


    private NumberPicker numPicker(NumberPicker np){

        nums = new String[60];

        for(int i=0; i<nums.length; i++)
            nums[i] = Integer.toString(i);

        np.setMinValue(0);
        np.setMaxValue(59);
        np.setDisplayedValues(nums);

        return np;


    }


    public void addSong(View v){

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);

        MyDbHelper aDbHelper = new MyDbHelper(this);

        songs = aDbHelper.lastSONGS();

        nSong = new Song((songs + 1),
                editTextTitle.getText().toString(),
                Integer.parseInt(nums[numberPickerMm.getValue()]),
                Integer.parseInt(nums[numberPickerSs.getValue()]),
                codAlbum
        );

        aDbHelper.insertSONG(nSong);

        /*Log.d("NUEVOS DATOS", (songs + 1) + "-" +
                editTextTitle.getText().toString() + "-" +
                Integer.parseInt(nums[numberPickerMm.getValue()]) + "-" +
                Integer.parseInt(nums[numberPickerSs.getValue()]) + "-" +
                codAlbum);*/

        finish();
    }

}
