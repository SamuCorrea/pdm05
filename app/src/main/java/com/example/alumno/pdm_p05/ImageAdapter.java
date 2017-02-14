package com.example.alumno.pdm_p05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pablo on 14/02/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] albumValues;

    public ImageAdapter(Context context, String[] albumValues) {
        this.context = context;
        this.albumValues = albumValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.songview, null);

            // set value into textview
            TextView textView = (TextView) gridView.findViewById(R.id.textViewDisk);
            textView.setText(albumValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView.findViewById(R.id.imageView);

            String album = albumValues[position];

            if (album.equals("letitbe")) {
                imageView.setImageResource(R.drawable.letitbe);
            }
            else if (album.equals("darksideofthemoon")) {
                imageView.setImageResource(R.drawable.darksideofthemoon);
            }
            else if (album.equals("thriller")) {
                imageView.setImageResource(R.drawable.thriller);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return albumValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}