package com.example.fap.ui.attendance;

public class AttendanceRecord {
    private String date;
    private String lecturer;
    private boolean present;

    public AttendanceRecord(String date, String lecturer, boolean present) {
        this.date = date;
        this.lecturer = lecturer;
        this.present = present;
    }

    public String getDate() { return date; }
    public String getLecturer() { return lecturer; }
    public boolean isPresent() { return present; }
}