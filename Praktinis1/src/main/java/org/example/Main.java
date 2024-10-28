package org.example;

import Model.Student;
import Transform.XMLTransformer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Main {
    public static void main(String[] args) {

        XMLTransformer transformer = new XMLTransformer();

        Student student = transformer.transformToPOJO("received_student.xml");

        // Проверяем, что объект успешно создан, и выводим его данные
        if (student != null) {
            System.out.println("Student name: " + student.getName());
            System.out.println("Student age: " + student.getAge());
            System.out.println("Student GPA: " + student.getGpa());
        } else {
            System.out.println("Failed to convert XML to POJO.");
        }
    }
}
