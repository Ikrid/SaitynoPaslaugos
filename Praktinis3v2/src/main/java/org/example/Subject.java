package org.example;



public class Subject {
    private String subjectName;
    private int credits;

    public Subject() {}

    public Subject(String subjectName, int credits) {
        this.subjectName = subjectName;
        this.credits = credits;
    }

    // Getters and Setters
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", credits=" + credits +
                '}';
    }
}
