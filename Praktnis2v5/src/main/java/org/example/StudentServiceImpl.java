package org.example;

import org.example.Student;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.example.StudentService")
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Anna", 20));
        students.add(new Student("Jonas", 22));
        return students;
    }
}