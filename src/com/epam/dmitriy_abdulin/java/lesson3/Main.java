package com.epam.dmitriy_abdulin.java.lesson3;

import javafx.util.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        Main app = new Main();
        app.start();
    }

    private void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Student firstStudent = new Student("Ivan", "Ivanov", "J2EE Developer", simpleDateFormat.parse("27.03.2018"));
        Student secondStudent = new Student("Petr", "Petrov", "Java Developer", simpleDateFormat.parse("02.04.2018"));

        Course technologyJavaServlets = new Course("Технология Java Servlets", 16);
        Course strutsFramework = new Course("Struts Framework", 24);
        Course reviewTechnologyJava = new Course("Обзор технологий Java", 8);
        Course libraryJFCSwing = new Course("Библиотека JFC/Swing", 16);
        Course technologyJDBC = new Course("Технология JDBC", 5);

        List<Course> firstStudentCourses = new ArrayList<>();
        firstStudentCourses.add(technologyJavaServlets);
        firstStudentCourses.add(strutsFramework);

        List<Course> secondStudentCourses = new ArrayList<>();
        secondStudentCourses.add(reviewTechnologyJava);
        secondStudentCourses.add(libraryJFCSwing);
        secondStudentCourses.add(technologyJDBC);


        List<Pair<Student, List<Course>>> fullStudentData = new ArrayList<>();
        fullStudentData.add(new Pair<>(firstStudent, firstStudentCourses));
        fullStudentData.add(new Pair<>(secondStudent, secondStudentCourses));

        System.out.println("1 - short report");
        System.out.println("2 - detailed report");
        int parameterOfReport = scanner.nextInt();

        for (Pair<Student, List<Course>> studentListPair : fullStudentData) {
            System.out.println(studentListPair.getKey().toString());
            //Report report = new Report();
            printTheReport(studentListPair.getKey().getStartDate(), studentListPair.getValue(), parameterOfReport);
        }
    }

    private void printTheReport(Date startDate, List<Course> courses, int parameterOfReport) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat simpleHourFormat = new SimpleDateFormat("HH");
        Date currentDate = new Date();
        Date currentHour = new Date();
        simpleDateFormat.format(currentDate);
        simpleHourFormat.format(currentHour);

        int allHoursOfCourse = 0;
        for (Course course : courses) {
            allHoursOfCourse += course.durationCourse;
        }

        int daysOfCourse = allHoursOfCourse / 8;
        int hoursOfCourse = allHoursOfCourse % 8;

        long differenceBetweenDates = currentDate.getTime() - startDate.getTime();
        int passedDays = (int) (differenceBetweenDates / (24 * 60 * 60 * 1000));
        int passedHours = Integer.parseInt(simpleHourFormat.format(currentHour));

        if (parameterOfReport == 1) {
            if (passedDays > daysOfCourse || (passedDays == daysOfCourse && passedHours >= hoursOfCourse + 10)) {
                System.out.println("Обучение завершено.");
            } else {
                System.out.println("Обучение не завершено.");
            }
        } else {
            System.out.println("Длительность программы в часах - " + allHoursOfCourse + " ч");
            System.out.println("Дата старта: " + simpleDateFormat.format(startDate));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            int addDays = daysOfCourse;
            if (hoursOfCourse != 0)
                addDays++;
            calendar.add(Calendar.DAY_OF_MONTH, addDays - 1);
            Date finishDate = calendar.getTime();
            System.out.println("Дата завершения: " + simpleDateFormat.format(finishDate));

            if (passedDays > daysOfCourse || (passedDays == daysOfCourse && Integer.parseInt(String.valueOf(currentHour)) >= hoursOfCourse + 10)) {
                int laterDays = passedDays - daysOfCourse;
                int laterHours = Math.min(18, passedHours) - (hoursOfCourse + 10);
                System.out.print("После окончания прошло ");
                System.out.print(laterDays + " д ");
                System.out.println(laterHours + " ч" + "\n");
            } else {
                int leftDays = daysOfCourse - passedDays;
                if (passedHours >= 18) {
                    leftDays--;
                }
                int leftHours = (hoursOfCourse + 10) - Math.min(10, Math.max(10, passedHours));
                System.out.print("До окончания осталось ");
                System.out.print(leftDays + " д ");
                System.out.println(leftHours + " ч" + "\n");
            }
        }
    }
}
