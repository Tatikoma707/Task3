package com.epam.dmitriy_abdulin.java.lesson3;


public class Course {
    private String nameCourse;
    public Integer durationCourse;

    public Course(String nameCourse, Integer durationCourse) {
        this.nameCourse = nameCourse;
        this.durationCourse = durationCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Integer getDurationCourse() {
        return durationCourse;
    }

    public void setDurationCourse(Integer durationCourse) {
        this.durationCourse = durationCourse;
    }
}
