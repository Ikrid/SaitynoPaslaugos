package org.example;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private float grade;
    private boolean enrolled;
    private char section;
    private List<Subject> subjects;

    // Конструктор по умолчанию
    public Student() {}

    // Конструктор с параметрами
    public Student(int id, String name, int age, float grade, boolean enrolled, char section, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.enrolled = enrolled;
        this.section = section;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", enrolled=" + enrolled +
                ", section=" + section +
                ", subjects=" + subjects +
                '}';
    }
}
