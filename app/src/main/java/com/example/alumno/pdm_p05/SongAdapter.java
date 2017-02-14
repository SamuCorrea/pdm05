package com.example.alumno.pdm_p05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pablo on 11/02/17.
 */

public class SongAdapter extends BaseAdapter {


    private Context context;
    private List<Song> items;
    MyDbHelper aDbHelper;

    public SongAdapter(Context context, List<Song> items) {
        this.context = context;
        this.items = items;
        this.aDbHelper = new MyDbHelper(context);
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
            rowView = inflater.inflate(R.layout.songlist, parent, false);
        }

        // Set data into the view.
        TextView textViewTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView textViewDuration = (TextView) rowView.findViewById(R.id.textViewDuration);
        TextView textViewTrackNumber = (TextView) rowView.findViewById(R.id.textViewTrackNumber);
        ImageButton imageButtonDel = (ImageButton) rowView.findViewById(R.id.imageButtonDel);

        // DELETE WHEN CLICK ON THE BIN
        imageButtonDel.setTag(position);

        imageButtonDel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer index = (Integer) v.getTag();


                        int auxAlbumCode = items.get(index.intValue()).getAlbumCode();
                        int auxSongID = items.get(index.intValue()).getTrackNumber();
                        aDbHelper.deleteSONG(auxSongID, auxAlbumCode);

                        items.remove(index.intValue());
                        notifyDataSetChanged();
                    }
                }
        );



        Song item = this.items.get(position);

        textViewTrackNumber.setText("" + item.getTrackNumber());
        textViewTitle.setText(item.getTitle());

        if (item.getSs() <10)
        {
            textViewDuration.setText(item.getMm()
                    + ":0"
                    + item.getSs());
        }
        else
        {
            textViewDuration.setText(item.getMm()
                    + ":"
                    + item.getSs());
        }



        return rowView;
    }

}
