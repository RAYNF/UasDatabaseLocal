package com.example.proa1113419;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String NAMA_DATABASE="AKADEMIK";
    public final static String NAMA_TABLE="MATAKULIAH";
    public final static String field01="kode";
    public final static String field02="nama_mtkl";
    public final static String field03="sks";
    public final static String field04="alamat";
    public final static String field05="kota";
    public final static String field06="predikat";

    public DatabaseHelper(Context context) {
        super(context, NAMA_DATABASE, null, 2);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NAMA_TABLE+"(kode text primary key," +
                " nama_mtkl text," +
                "sks text,"+"alamat text,"+"kota text,"+"predikat text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABLE);
        onCreate(db);
    }

    public boolean input_matakuliah(String xkode, String xnama, String xsks,String xalamat,String xkota,String xpredikat) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkode);
        contentValues.put(field02,xnama);
        contentValues.put(field03,xsks);
        contentValues.put(field04,xalamat);
        contentValues.put(field05,xkota);
        contentValues.put(field06,xpredikat);
        long hasil=db.insert(NAMA_TABLE,null,contentValues);
        if(hasil>0) {
            return true;
        }else{
            return false;
        }
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from "+NAMA_TABLE,null);
        return cur;
    }

    public void ubah_data(String xkode, String xnama, String xsks,String xalamat,String xkota,String xpredikat) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkode);
        contentValues.put(field02,xnama);
        contentValues.put(field03,xsks);
        contentValues.put(field04,xalamat);
        contentValues.put(field05,xkota);
        contentValues.put(field06,xpredikat);
        db.update(NAMA_TABLE,contentValues,"kode=?",new String[]{xkode});
    }

    public void hapus_matakuliah(String xkode) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkode);
        db.delete(NAMA_TABLE,"kode=?",new String[]{xkode});
    }
    public String totalsks(){
        SQLiteDatabase db=this.getWritableDatabase();//nyambungke database
        String sks;
        String sQuery = "select sum(sks) from "+NAMA_TABLE; //perintah database
        Cursor cursor = db.rawQuery(sQuery,null);
        if (cursor.moveToFirst()) //fungsi menghitung
        {
            sks=String.valueOf(cursor.getInt(0));
        }
        else{
            sks="0";
        }
        cursor.close();
        db.close();
        return sks;
    }

    public String jumlahmatkul(){
        SQLiteDatabase db=this.getWritableDatabase();
        String jmlmatkul;
        String sQuery = "select count(kode) from "+NAMA_TABLE;
        Cursor cursor = db.rawQuery(sQuery,null);
        if (cursor.moveToFirst())
        {
            jmlmatkul=String.valueOf(cursor.getInt(0));
        }
        else{
            jmlmatkul="0";
        }
        db.close();
        return jmlmatkul;
    }

}