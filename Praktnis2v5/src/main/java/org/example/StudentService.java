package org.example;

import org.example.Student;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface StudentService {
    @WebMethod
    List<Student> getStudents();
}