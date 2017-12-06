/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Felipe Padua
 */
public class Syllabus {
    private int id;
    private String content;
    private Date date;
    private int publishedStatus;
    private int course_idCourse;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(int publishedStatus) {
        this.publishedStatus = publishedStatus;
    }
    
    public int getCourse_idCourse() {
        return this.course_idCourse;
    }

    public void setCourse_idCourse(int course_idCourse) {
        this.course_idCourse = course_idCourse;
    }
    
}
