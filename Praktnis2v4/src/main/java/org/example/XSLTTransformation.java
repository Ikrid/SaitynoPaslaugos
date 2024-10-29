package org.example;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTTransformation {
    public static void main(String[] args) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new File("src/main/resources/transform.xsl")));

        // Используем ClassLoader для поиска файла students.xml
        ClassLoader classLoader = XSLTTransformation.class.getClassLoader();
        File xmlFile = new File(classLoader.getResource("students.xml").getFile());

        transformer.transform(new StreamSource(xmlFile), new StreamResult(new File("output.html")));
        System.out.println("Transformation complete");
    }
}
