package com.example.cardio_tracker;
/**
 * This  class will be used to create object of database data.
 */
public class model {


    int id;
    String systolic,diastolic,pulse,comment,ms_date,ms_time;
    /**
     * It's a constructor of model class will be used to set data in recyclerView.
     * @param id
     * @param systolic
     * @param diastolic
     * @param pulse
     * @param comment
     * @param ms_date
     * @param ms_time
     */
    public model(int id, String systolic, String diastolic, String pulse, String comment, String ms_date, String ms_time) {
        this.id = id;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
        this.comment = comment;
        this.ms_date = ms_date;
        this.ms_time = ms_time;
    }

    /**
     *
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return Sytolic value
     */

    public String getSystolic() {
        return systolic;
    }

    /**
     *
     * @param systolic
     */

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    /**
     *
     * @return diastolic pressure
     */
    public String getDiastolic() {
        return diastolic;
    }

    /**
     *
     * @param diastolic
     */

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    /**
     *
     * @return pulse rate
     */
    public String getPulse() {
        return pulse;
    }

    /**
     *
     * @param pulse
     */
    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    /**
     *
     * @return Comment done by user
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return System date
     */
    public String getMs_date() {
        return ms_date;
    }

    /**
     *
     * @param ms_date
     */
    public void setMs_date(String ms_date) {
        this.ms_date = ms_date;
    }

    /**
     *
     * @return system_time
     */
    public String getMs_time() {
        return ms_time;
    }

    /**
     *
     * @param ms_time
     */
    public void setMs_time(String ms_time) {
        this.ms_time = ms_time;
    }
}
