package com.example.alumno.pdm_p05;

import java.sql.Time;

/**
 * Created by alumno on 7/02/17.
 */

public class Song {

    // ATTRIBS

    private int trackNumber;
    private String title;
    private Time duration;
    private String albumTitle;

    // CONSTRUCTOR

    public Song (int trackNumber, String title, Time duration, String albumTitle)
    {
        this.trackNumber = trackNumber;
        this.title = title;
        this.duration = duration;
        this.albumTitle = albumTitle;

    }

    // METHODS

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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
}
