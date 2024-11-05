package com.example.fap.ui.mark;

public class Mark {
    private String courseCode;
    private String courseName;
    private String className;
    private double average;
    private boolean isPresent;

    public Mark(String courseCode, String courseName, String className, double average, boolean isPresent) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.className = className;
        this.average = average;
        this.isPresent = isPresent;
    }

    // Getters
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getClassName() { return className; }
    public double getAverage() { return average; }
    public boolean isPresent() { return isPresent; }
}
