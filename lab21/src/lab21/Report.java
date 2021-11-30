/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

/**
 *
 * @author DELL
 */
public class Report {
    private String studentName, course, id;
    private int totalCourse;

    public Report() {
    }

    public Report(String studentName, String course, String id, int totalCourse) {
        this.studentName = studentName;
        this.course = course;
        this.id = id;
        this.totalCourse = totalCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return "Student Name: " + studentName +" | "+ "Course: " + course +" | "+ "Total Course: " + totalCourse ;
    }
    
    
}
