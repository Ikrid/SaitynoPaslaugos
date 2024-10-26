package Transform;

import Model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLTransformer {

    public Student transformToPOJO(String xmlFilePath) {
        try {
            // Creates JAXB context for the class Student
            JAXBContext context = JAXBContext.newInstance(Student.class);

            // Create unmarshaller to convert XML to object
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Convert XML to Student object
            return (Student) unmarshaller.unmarshal(new File(xmlFilePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}