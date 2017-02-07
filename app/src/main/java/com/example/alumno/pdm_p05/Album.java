package com.example.alumno.pdm_p05;

import java.util.Calendar;

/**
 * Created by alumno on 7/02/17.
 */

public class Album {

    // ATTRIBS

    private int code;
    private String title;
    private String author;
    private Calendar dateRelease;


    // CONSTRUCTOR

    public Album (int code, String title, String author, Calendar date)
    {
        this.code = code;
        this.title = title;
        this.author = author;
        this.dateRelease = date;
    }


    // METHODS


    // GETTERS && SETTERS

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Calendar getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Calendar dateRelease) {
        this.dateRelease = dateRelease;
    }
}
