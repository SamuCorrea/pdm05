package com.example.alumno.pdm_p05;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class ImageActivity extends AppCompatActivity {

    GridView gridView;

    static final String[] DISC = new String[] { "letitbe", "darksideofthemoon", "thriller" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        gridView = (GridView) findViewById(R.id.GridView);

        gridView.setAdapter(new ImageAdapter(this, DISC));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                TextView textView = (TextView) v.findViewById(R.id.textViewDisk);

                Intent data = new Intent();

                data.putExtra("image", textView.getText().toString());

                setResult(RESULT_OK, data);

                finish();



                /*Toast.makeText(
                        getApplicationContext(),
                        ((TextView) v.findViewById(R.id.textViewDisk))
                                .getText(), Toast.LENGTH_SHORT).show();*/

            }
        });
    }
}
