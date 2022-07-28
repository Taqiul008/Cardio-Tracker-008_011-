package com.example.cardio_tracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * This  adapter class will fit data in recyclerView
 */
public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    Context context;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<model> dataholder;
    /**
     * It is constructor of myadapter class.
     * @param context
     * @param sqLiteDatabase
     * @param dataholder
     */

    public myadapter(Context context, SQLiteDatabase sqLiteDatabase, ArrayList<model> dataholder) {
        this.context = context;
        this.sqLiteDatabase = sqLiteDatabase;
        this.dataholder = dataholder;
    }
    /**
     * This function will show the measurement_list_card layout in recycler view.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.measurement_list_card,parent,false);
        return new myviewholder(view);
    }
    /**
     * This method will set value in measurement_list_card layouts text field .Inside this function update and delete function will be called.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        String s1=dataholder.get(position).getSystolic().toString()+"mmHg";
        holder.dSystolic.setText(s1);
        String s2=dataholder.get(position).getDiastolic().toString()+"mmHg";
        holder.dDistolic.setText(s2);
        String s3=dataholder.get(position).getPulse().toString()+"bps";
        holder.dPulse.setText(s3);
        holder.dComment.setText(dataholder.get(position).getComment());
        final  model md=dataholder.get(position);
        int  x=Integer.parseInt(md.getSystolic());
        int y=Integer.parseInt(md.getDiastolic());
        int z=Integer.parseInt(md.getPulse());
        if((x>=90 && x<=140) && (y>=60 && y<=90) && (z>65 && z<85))
        {

            Integer f=R.drawable.healthy;
            holder.img.setImageResource(f);
        }

        holder.dms_date.setText(md.getMs_date());
        holder.dTime.setText(md.getMs_time());
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle=new Bundle();
                bundle.putInt("id",md.getId());
                bundle.putString("systolic",md.getSystolic());
                bundle.putString("diastolic",md.getDiastolic());
                bundle.putString("pulse",md.getPulse());
                bundle.putString("comment",md.getComment());
                bundle.putString("ms_date",md.getMs_date());
                bundle.putString("ms_time",md.getMs_time());
                Intent intent=new Intent(context,addData.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);

            }
        });
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to delete ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        manager mgr=new manager(context);
                        String Table_name="Tbl_contact";
                        SQLiteDatabase db=mgr.getReadableDatabase();
                        long rec=db.delete(Table_name,"id="+md.getId(),null);
                        if(rec!=-1)
                        {
                            Toast.makeText(context,"Delete Successfully",Toast.LENGTH_SHORT).show();
                            dataholder.remove(holder.getAdapterPosition());
                            notifyDataSetChanged();
                        }
                        else
                        {
                            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Cardio-Tracker");
                alert.show();
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#ff6777"));
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#ff6777"));


            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class  myviewholder extends RecyclerView.ViewHolder{

        TextView dSystolic,dDistolic,dPulse,dComment,dms_date,dTime;
        Button button1,button2;
        ImageView img;

        public myviewholder(@NonNull View itemView) {
            /**
             * This function will generate alert dialogue in which user will confirm if data will delete or not.
             * @param view
             */
            super(itemView);
            dSystolic=(TextView) itemView.findViewById(R.id.systolic_list);
            dDistolic=(TextView) itemView.findViewById(R.id.diastolic_list);
            dPulse=(TextView) itemView.findViewById(R.id.pulse_list);
            dComment=(TextView) itemView.findViewById(R.id.comment_list);
            dms_date=(TextView) itemView.findViewById(R.id.date_list);
            dTime=(TextView) itemView.findViewById(R.id.time_list);
            button1=(Button) itemView.findViewById(R.id.delete_list);
            button2=(Button) itemView.findViewById(R.id.update_list);
            img =(ImageView) itemView.findViewById(R.id.danger);
        }
    }
}
