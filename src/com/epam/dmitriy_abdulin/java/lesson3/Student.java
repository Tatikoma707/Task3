package com.epam.dmitriy_abdulin.java.lesson3;

import java.util.Date;

public class Student {

    private String firstName;
    private String secondName;
    private String curriculum;
    private Date startDate;

    public Student(String firstName, String secondName, String curriculum, Date startDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.curriculum = curriculum;
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName + " (" + this.curriculum + ")";
    }
}
