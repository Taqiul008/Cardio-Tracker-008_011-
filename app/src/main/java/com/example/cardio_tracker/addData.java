package com.example.cardio_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class addData extends AppCompatActivity {
    EditText systolic,diastolic,comment,pulse;
    Button add,update;
    SQLiteDatabase db;
    String Table_name;
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        manager mgr=new manager(this);
        Table_name="tbl_contact";

        systolic=findViewById(R.id.systolic);
        diastolic=findViewById(R.id.dystolic);
        comment=findViewById(R.id.comment);
        pulse=findViewById(R.id.pulse);

        add=findViewById(R.id.submit);
        update=findViewById(R.id.edit);

        add.setVisibility(View.VISIBLE);
        update.setVisibility(View.INVISIBLE);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=systolic.getText().toString();

                int x=Integer.parseInt(s1);
                if(x<95 || x>160)
                {
                    systolic.setError("Corrupted Data!");
                    return;
                }

                String s2=diastolic.getText().toString();
                x=Integer.parseInt(s2);
                if(x<60 || x>94)
                {
                    diastolic.setError("Corrupted Data!");
                    return;
                }

                String s3=pulse.getText().toString();
                x=Integer.parseInt(s3);
                if(x<20 || x>140)
                {
                    pulse.setError("Corrupted Data!");
                    return;
                }

                String s4=comment.getText().toString();
                // Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_SHORT).show();
                precessinsert(s1,s2,s3,s4);
                systolic.setText("");
                diastolic.setText("");
                comment.setText("");
                Intent intent=new Intent(getApplicationContext(),recycler_Show.class);
                startActivity(intent);
            }
        });

        editData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String date = sdf.format(System.currentTimeMillis());

                SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
                String time = sd.format(System.currentTimeMillis());

                String s1=systolic.getText().toString();

                int x=Integer.parseInt(s1);
                if(x<95 || x>160)
                {
                    systolic.setError("Corrupted Data!");
                    return;
                }

                String s2=diastolic.getText().toString();
                x=Integer.parseInt(s2);
                if(x<60 || x>94)
                {
                    diastolic.setError("Corrupted Data!");
                    return;
                }

                String s3=pulse.getText().toString();
                x=Integer.parseInt(s3);
                if(x<20 || x>140)
                {
                    pulse.setError("Corrupted Data!");
                    return;
                }


                String s4=comment.getText().toString();

                ContentValues cv=new ContentValues();
                cv.put("systolic",s1);
                cv.put("diastolic",s2);
                cv.put("pulse",s3);
                cv.put("comment",s4);
                cv.put("ms_date",date);
                cv.put("ms_time",time);


                long recedit=mgr.updateRecod(id,s1,s2,s3,s4,date,time);
                if(recedit!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
                    systolic.setText("");
                    diastolic.setText("");
                    comment.setText("");
                    pulse.setText("");
                    Intent intent=new Intent(getApplicationContext(),recycler_Show.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    private void editData() {

        if(getIntent().getBundleExtra("userdata")!=null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            id = bundle.getInt("id");
            String s1 = bundle.getString("systolic");
            String s2 = bundle.getString("diastolic");
            String s3 = bundle.getString("pulse");
            String s4 = bundle.getString("comment");
            add.setVisibility(View.INVISIBLE);
            update.setVisibility(View.VISIBLE);
            systolic.setText(s1);
            diastolic.setText(s2);
            pulse.setText(s3);
            comment.setText(s4);
        }


    }

    private void precessinsert(String s1, String s2, String s3, String s4) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(System.currentTimeMillis());

        SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
        String time = sd.format(System.currentTimeMillis());
        long result=new manager(this).addrecod(s1,s2,s3,s4,date,time);

        if(result==-1)
        {
            Toast.makeText(getApplicationContext(),"Failed To Add",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_SHORT).show();
        }

        systolic.setText("");
        diastolic.setText("");
        pulse.setText("");
        comment.setText("");
    }
}
