package com.example.alumno.pdm_p05;

import android.content.ContentValues;

import java.util.Calendar;

/**
 * Created by alumno on 7/02/17.
 */

public class Album {

    // ATTRIBS

    private int code;
    private String title;
    private String author;
    private int dd;
    private int mm;
    private int yyyy;
    private String image_id;

    // CONSTRUCTOR

    public Album (int code, String title, String author, int dd, int mm, int yyyy, String image_id)
    {
        this.code = code;
        this.title = title;
        this.author = author;
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        this.setImage_id(image_id);
    }

    public Album () {


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


    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }


    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getYyyy() {
        return yyyy;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

}
