package org.example;

import org.example.StudentServiceImplService;
import org.example.StudentService;

public class WebServiceClient {
    public static void main(String[] args) {

        StudentServiceImplService service = new StudentServiceImplService();
        StudentService studentService = service.getStudentServiceImplPort();


        System.out.println(studentService.getStudents());
    }
}
