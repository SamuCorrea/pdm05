package com.example.alumno.pdm_p05;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by alumno on 7/02/17.
 */

public class Song implements Parcelable {

    // ATTRIBS

    private int trackNumber;
    private String title;
    private int mm;
    private int ss;
    private int albumCode;

    // CONSTRUCTOR

    public Song (int trackNumber, String title, int mm, int ss, int albumCode)
    {
        this.trackNumber = trackNumber;
        this.title = title;
        this.setMm(mm);
        this.setSs(ss);
        this.setAlbumCode(albumCode);

    }

    public Song(Parcel p) {

        readFromParcel(p);

    }

    // METHODS


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeInt(mm);
        dest.writeInt(ss);
        dest.writeInt(trackNumber);
        dest.writeInt(albumCode);

    }
    private void readFromParcel(Parcel in) {

        title = in.readString();
        mm = in.readInt();
        ss = in.readInt();
        trackNumber = in.readInt();
        albumCode = in.readInt();

    }


    // METHODS FOR LIST

    public static final Parcelable.Creator<Song> CREATOR
            = new Parcelable.Creator<Song>() {
        public Song createFromParcel(Parcel in) {

            return new Song(in);
        }

        public Song[] newArray(int size) {
            return new Song[size];
        }
    };







    // GETTERS && SETTERS

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public int getAlbumCode() {
        return albumCode;
    }

    public void setAlbumCode(int albumCode) {
        this.albumCode = albumCode;
    }
}