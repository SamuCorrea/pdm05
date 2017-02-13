package com.example.alumno.pdm_p05;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Samuel on 10/02/2017.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mibasedatos4.db";
    private static final String CREATE_ALBUMS ="CREATE TABLE IF NOT EXISTS albums " +
            " (_id INTEGER PRIMARY KEY, title TEXT, author TEXT, dd INTEGER, mm INTEGER, YYYY INTEGER, img TEXT)";
    private static final String CREATE_SONGS ="CREATE TABLE IF NOT EXISTS songs " +
            " (_id INTEGER PRIMARY KEY, title TEXT, mm INTEGER, ss INTEGER, album_id INTEGER, FOREIGN KEY (album_id) REFERENCES albums)";


    public MyDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {                                                       // ON CREATE

        db.execSQL("PRAGMA foreign_keys = ON;");
        db.execSQL(CREATE_ALBUMS);
        db.execSQL(CREATE_SONGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {                      // ON UPGRADE
        db.execSQL("PRAGMA foreign_keys = ON;");
        db.execSQL("DROP TABLE IF EXISTS; " + CREATE_ALBUMS);
        db.execSQL("DROP TABLE IF EXISTS; " + CREATE_SONGS);
        onCreate(db);
    }

    public void deleteAllALBUMS() {                                                                     // DELETE ALBUMS
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            db.execSQL("DELETE FROM albums;");
            db.execSQL("VACUUM;");
        }
        db.close();
    }

    public void dropTableSONGS() {
        SQLiteDatabase db = getWritableDatabase();                                                  // DROP SONGS
        if (db != null) {
            db.execSQL("DROP TABLE songs;");
        }
        db.close();
    }

    public void deleteAllSONGS() {                                                                  // DELETE SONGS
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            db.execSQL("DELETE FROM songs;");
            db.execSQL("VACUUM;");
        }
        db.close();
    }

    public void dropTableALBUMS() {
        SQLiteDatabase db = getWritableDatabase();                                                  // DROP ALBUMS
        if (db != null) {
            db.execSQL("DROP TABLE albums;");
        }
        db.close();
    }

    public int countALBUMBS () {                                                                    // COUNT ALBUMS
        SQLiteDatabase db = getWritableDatabase();
        int count=0;
        if (db != null) {
            Cursor mCount= db.rawQuery("SELECT COUNT(*) FROM albums", null);
            mCount.moveToFirst();
            count= mCount.getInt(0);
            mCount.close();
        }
        db.close();
        return count;
    }

    public int lastALBUMBS () {                                                                    // LAST ALBUMS
        SQLiteDatabase db = getWritableDatabase();
        int count=0;
        if (db != null) {
            Cursor mCount= db.rawQuery("SELECT MAX(_ID) FROM albums", null);
            mCount.moveToFirst();
            count= mCount.getInt(0);
            mCount.close();
        }
        db.close();
        return count;
    }



    public int countSONGS () {                                                                      // COUNT SONGS
        SQLiteDatabase db = getWritableDatabase();
        int count=0;
        if (db != null) {
            Cursor mCount= db.rawQuery("SELECT COUNT(*) FROM songs", null);
            mCount.moveToFirst();
            count= mCount.getInt(0);
            mCount.close();
        }
        db.close();
        return count;
    }


    public int lastSONGS () {                                                                      // LAST SONGS
        SQLiteDatabase db = getWritableDatabase();
        int count=0;
        if (db != null) {
            Cursor mCount= db.rawQuery("SELECT MAX(_ID) FROM songs", null);
            mCount.moveToFirst();
            count= mCount.getInt(0);
            mCount.close();
        }
        db.close();
        return count;
    }


    /* INSERT ALBUM */                                                                              // INSERT ALBUM
    public boolean insertALBUM(Album album) {
        long salida=0;
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            if(album.getCode()!=0)
                valores.put("_id", album.getCode());
            valores.put("title", album.getTitle());
            valores.put("author", album.getAuthor());
            valores.put("dd", album.getDd());
            valores.put("mm", album.getMm());
            valores.put("yyyy", album.getYyyy());
            valores.put("img", album.getImage_id());
            salida=db.insert("albums", null, valores);
        }
        db.close();
        return(salida>0);
    }

    public boolean insertSONG(Song song) {                                                        // INSERT SONG
        long salida=0;
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();

            valores.put("_id",song.getTrackNumber());
            valores.put("title", song.getTitle());
            valores.put("mm", song.getMm());
            valores.put("ss", song.getSs());
            valores.put("album_id", song.getAlbumCode());
            salida=db.insert("songs", null, valores);
        }
        db.close();
        return(salida>0);
    }
    /*
        public boolean  modificarCONTACTO(int id, String nom, String tlf, String email){
            long salida=0;
            SQLiteDatabase db = getWritableDatabase();
            if (db != null) {
                ContentValues valores = new ContentValues();
                valores.put("_id", id);
                valores.put("nombre", nom);
                valores.put("telefono", tlf);
                valores.put("email", email);
                salida=db.update("contactos", valores, "_id=" + id, null);
            }
            db.close();
            return(salida>0);
        }
    */
    public boolean  deleteALBUM(int id) {                                                           // DELETE ALBUM BY ID
        SQLiteDatabase db = getWritableDatabase();
        long salida=0;
        if (db != null) {
            salida=db.delete("albums", "_id=" + id, null);
        }
        db.close();
        return(salida>0);
    }

    public boolean  deleteSONG(int id) {                                                           // DELETE SONG BY ID
        SQLiteDatabase db = getWritableDatabase();
        long salida=0;
        if (db != null) {
            salida=db.delete("songs", "_id=" + id, null);
        }
        db.close();
        return(salida>0);
    }
    /*
    public Contactos recuperarCONTACTO(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_id", "nombre", "telefono", "email"};
        Cursor c = db.query("contactos", valores_recuperar, "_id=" + id, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Contactos contactos = new Contactos(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
        db.close();
        c.close();
        return contactos;
    }

*/
    public ArrayList<Song> loadSONGS(int aID) {                                                     // LOAD SONGS
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Song> songList = new ArrayList<Song>();
        String[] valores_recuperar = {"_id", "title", "mm", "ss", "album_id"};
        String[] args = new String[] {String.valueOf(aID)};
        Cursor c = db.query("songs", valores_recuperar, "_id=?", args , null, null, null, null);
        c.moveToFirst();
        do {
            Song song = new Song (c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4));
            songList.add(song);
        } while (c.moveToNext());
        db.close();
        c.close();
        return songList;
    }

    public ArrayList<Album> loadALBUMS() {                                                          // LOAD ALBUMS
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Album> albumList = new ArrayList<Album>();
        String[] valores_recuperar = {"_id", "title", "author", "dd", "mm", "yyyy", "img"};
        Cursor c = db.query("albums", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Album album = new Album (c.getInt(0), c.getString(1), c.getString(2), c.getInt(3), c.getInt(4), c.getInt(5), c.getString(6));
            albumList.add(album);
        } while (c.moveToNext());
        db.close();
        c.close();
        return albumList;
    }


}

