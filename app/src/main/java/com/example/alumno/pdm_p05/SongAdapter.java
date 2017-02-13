package com.example.alumno.pdm_p05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pablo on 11/02/17.
 */

public class SongAdapter extends BaseAdapter {


    private Context context;
    private List<Song> items;

    public SongAdapter(Context context, List<Song> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.sounglist, parent, false);
        }

        // Set data into the view.
        TextView textViewTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView textViewDuration = (TextView) rowView.findViewById(R.id.textViewDuration);
        //Button imageButtonDel = (Button) rowView.findViewById(R.id.imageButtonDel);


        Song item = this.items.get(position);

        textViewTitle.setText(item.getTitle());
        textViewDuration.setText(item.getMm() + ":" + item.getSs());


        return rowView;
    }

}
