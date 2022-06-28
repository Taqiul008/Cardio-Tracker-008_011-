package com.example.cardio_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class recycler_Show extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> dataholder;
    manager mgr;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_show);

        recyclerView=findViewById(R.id.load_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        floatingActionButton=findViewById(R.id.floatbutton);

        Cursor cursor =new manager(this).readalldata();
        dataholder=new ArrayList<>();
        // Toast.makeText(getApplicationContext(),dataholder.size(),Toast.LENGTH_SHORT).show();
        mgr=new manager(this);
        while (cursor.moveToNext())
        {
            model obj=new model(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            dataholder.add(obj);
        }
        //Toast.makeText(getApplicationContext(),dataholder.size(),Toast.LENGTH_SHORT).show();
        SQLiteDatabase sqLiteDatabase=mgr.getReadableDatabase();
        myadapter adapter=new myadapter(this,sqLiteDatabase,dataholder);
        recyclerView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),addData.class);
                startActivity(intent);
                finish();
            }
        });

    }
}