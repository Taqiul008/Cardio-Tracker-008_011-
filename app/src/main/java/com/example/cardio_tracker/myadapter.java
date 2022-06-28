package com.example.cardio_tracker;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    Context context;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<model> dataholder;

    public myadapter(Context context, SQLiteDatabase sqLiteDatabase, ArrayList<model> dataholder) {
        this.context = context;
        this.sqLiteDatabase = sqLiteDatabase;
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.measurement_list_card,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.dSystolic.setText(dataholder.get(position).getSystolic());
        holder.dDistolic.setText(dataholder.get(position).getDiastolic());
        holder.dPulse.setText(dataholder.get(position).getPulse());
        holder.dComment.setText(dataholder.get(position).getComment());
        final  model md=dataholder.get(position);
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
                manager mgr=new manager(context);
                String Table_name="Tbl_contact";
                SQLiteDatabase db=mgr.getReadableDatabase();
                long rec=db.delete(Table_name,"id="+md.getId(),null);
                if(rec!=-1)
                {
                    Toast.makeText(context,"Delete Successfully",Toast.LENGTH_SHORT).show();
                    dataholder.remove(position);
                    notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
                }
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
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dSystolic=(TextView) itemView.findViewById(R.id.systolic_list);
            dDistolic=(TextView) itemView.findViewById(R.id.diastolic_list);
            dPulse=(TextView) itemView.findViewById(R.id.pulse_list);
            dComment=(TextView) itemView.findViewById(R.id.comment_list);
            dms_date=(TextView) itemView.findViewById(R.id.date_list);
            dTime=(TextView) itemView.findViewById(R.id.time_list);
            button1=(Button) itemView.findViewById(R.id.delete_list);
            button2=(Button) itemView.findViewById(R.id.update_list);
        }
    }
}
