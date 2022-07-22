package com.example.cardio_tracker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.text.SimpleDateFormat;

@RunWith(RobolectricTestRunner.class)
public class UnitTest {

    @Test
    public void testAdd()
    {
        manager mgr=new manager(RuntimeEnvironment.application);
        String systolic="110";
        String diastolic="85";
        String pulse="75";
        String comment="Good";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(System.currentTimeMillis());

        SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
        String time = sd.format(System.currentTimeMillis());
        long id=mgr.addrecod(systolic,diastolic,pulse,comment,date,time);
        assertTrue(id>0);
        mgr.close();

    }

    @Test
    public void testUpdate()
    {
        manager mgr=new manager(RuntimeEnvironment.application);
        String systolic="110";
        String diastolic="85";
        String pulse="75";
        String comment="Good";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(System.currentTimeMillis());

        SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
        String time = sd.format(System.currentTimeMillis());
        long id=mgr.addrecod(systolic,diastolic,pulse,comment,date,time);

        String systolic2="110";
        String diastolic2="85";
        String pulse2="75";
        String comment2="Bad";
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date2 = sdf.format(System.currentTimeMillis());
        String time2 = sd.format(System.currentTimeMillis());
        int id2=(int)id;
        long idd=mgr.updateRecod(id2,systolic2,diastolic2,pulse2,comment2,date2,time2);
        assertTrue(idd>0);
        mgr.close();

    }

    @Test
    public void testDelete()
    {
        manager mgr=new manager(RuntimeEnvironment.application);
        String systolic="110";
        String diastolic="85";
        String pulse="75";
        String comment="Good";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(System.currentTimeMillis());

        SimpleDateFormat sd = new SimpleDateFormat("hh:mm");
        String time = sd.format(System.currentTimeMillis());
        long id=mgr.addrecod(systolic,diastolic,pulse,comment,date,time);
        int idd=(int)id;
        long t=mgr.delete(idd);
        assertTrue(t>0);
        mgr.close();
    }
}
