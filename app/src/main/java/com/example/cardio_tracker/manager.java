package com.example.cardio_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class manager extends SQLiteOpenHelper {

    private  static  final  String dbname="dbcontact";
    public manager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry="create table tbl_contact (id integer primary key autoincrement, systolic text, diastolic text,pulse text, comment text, ms_date text,ms_time text)";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String qry="DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public  String addrecod(String systolic, String diastolic ,String pulse, String comment, String ms_date,String ms_time)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("systolic",systolic);
        cv.put("diastolic",diastolic);
        cv.put("pulse",pulse);
        cv.put("comment",comment);
        cv.put("ms_date",ms_date);
        cv.put("ms_time",ms_time);
        float res=db.insert("tbl_contact",null,cv);
        if(res==-1)return "Failed";
        else return "Successfully inserted";
    }

    public  long updateRecod(int id,String systolic, String diastolic ,String pulse, String comment, String ms_date,String ms_time)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("systolic",systolic);
        cv.put("diastolic",diastolic);
        cv.put("pulse",pulse);
        cv.put("comment",comment);
        cv.put("ms_date",ms_date);
        cv.put("ms_time",ms_time);
        long res=db.update("tbl_contact",cv,"id="+id,null);
        return  res;
    }

    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }


}

