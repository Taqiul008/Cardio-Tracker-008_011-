package com.example.cardio_tracker;

public class model {


    int id;
    String systolic,diastolic,pulse,comment,ms_date,ms_time;

    public model(int id, String systolic, String diastolic, String pulse, String comment, String ms_date, String ms_time) {
        this.id = id;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
        this.comment = comment;
        this.ms_date = ms_date;
        this.ms_time = ms_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSystolic() {
        return systolic;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMs_date() {
        return ms_date;
    }

    public void setMs_date(String ms_date) {
        this.ms_date = ms_date;
    }

    public String getMs_time() {
        return ms_time;
    }

    public void setMs_time(String ms_time) {
        this.ms_time = ms_time;
    }
}
