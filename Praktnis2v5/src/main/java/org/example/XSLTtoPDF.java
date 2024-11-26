package org.example;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class XSLTtoPDF {
    public static void main(String[] args) throws Exception {

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());


        File pdfFile = new File("output.pdf");
        OutputStream out = new FileOutputStream(pdfFile);

        try {

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);


            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File("src/main/resources/transform-fo.xsl")));

            // Входные данные
            File xmlFile = new File("src/main/resources/students.xml");

            transformer.transform(new StreamSource(xmlFile), new SAXResult(fop.getDefaultHandler()));

            System.out.println("PDF создан успешно: " + pdfFile.getAbsolutePath());
        } finally {
            out.close();
        }
    }
}
