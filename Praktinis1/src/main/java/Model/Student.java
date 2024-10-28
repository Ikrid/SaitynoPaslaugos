package Model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Student {

    private String name;
    private int age;
    private float gpa;
    private boolean isEnrolled;
    private List<Subject> subjects;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    @XmlElement
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    @XmlElement
    public void setEnrolled(boolean enrolled) {
        isEnrolled = enrolled;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @XmlElement
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
