package com.example.fap.ui.attendance;

public class AttendanceItem {
    private String title;
    private String className;
    private String startDate;
    private String endDate;
    private int percentage;

    public AttendanceItem(String title, String className, String startDate, String endDate, int percentage) {
        this.title = title;
        this.className = className;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percentage = percentage;
    }

    // Getters
    public String getTitle() { return title; }
    public String getClassName() { return className; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public int getPercentage() { return percentage; }
}