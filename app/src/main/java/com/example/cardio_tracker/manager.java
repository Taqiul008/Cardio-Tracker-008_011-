package com.example.cardio_tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * This  class will be used to create ,insert,update,delete,fetch from database.
 */
public class manager extends SQLiteOpenHelper {

    private  static  final  String dbname="dbcontact";
    public manager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }
    /**
     * A table name='dbcontact' will create having column id,systolic,diastolic,pulse,comment,date and time.
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry="create table tbl_contact (id integer primary key autoincrement, systolic text, diastolic text,pulse text, comment text, ms_date text,ms_time text)";
        sqLiteDatabase.execSQL(qry);

    }
    /**
     * If there is a table with same name then the table will be drop.
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String qry="DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }
    /**
     * This function will perform insert operation.
     * @param systolic
     * @param diastolic
     * @param pulse
     * @param comment
     * @param ms_date
     * @param ms_time
     * @return
     */
    public  long addrecod(String systolic, String diastolic ,String pulse, String comment, String ms_date,String ms_time)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("systolic",systolic);
        cv.put("diastolic",diastolic);
        cv.put("pulse",pulse);
        cv.put("comment",comment);
        cv.put("ms_date",ms_date);
        cv.put("ms_time",ms_time);
        long res=db.insert("tbl_contact",null,cv);
        return res;
    }
    /**
     * This function will perform Update operation.
     * @param id
     * @param systolic
     * @param diastolic
     * @param pulse
     * @param comment
     * @param ms_date
     * @param ms_time
     * @return
     */
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

    /**
     * Read all data from from database.
     * @return single row from table using cursor
     */
    public Cursor readalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select * from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }
    /**
     * This function will perform Delete operation.
     * @param id
     * @return
     */
    public long delete(int id)
    {
        String Table_name="Tbl_contact";
        SQLiteDatabase db=this.getWritableDatabase();
        long rec=db.delete(Table_name,"id="+id,null);
        return rec;
    }


}

