package Transform;

import Model.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * XMLTransformer klasė, atsakinga už XML failų transformaciją į POJO objektus.
 * Naudojama JAXB biblioteka XML konvertavimui į Java objektus.
 */
public class XMLTransformer {

    /**
     * Transformuoja XML failą į Library objektą.
     *
     * @param xmlFilePath kelias iki XML failo, kuris bus transformuojamas.
     * @return Library objektas, jei transformacija pavyko, arba null, jei įvyko klaida.
     */
    public Library transformToPOJO(String xmlFilePath) {
        try {
            // Sukuria JAXB kontekstą klasei Library
            JAXBContext context = JAXBContext.newInstance(Library.class);

            // Sukuria unmarshaller'į, skirtą XML konvertavimui į objektą
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Konvertuoja XML failą į Library objektą
            return (Library) unmarshaller.unmarshal(new File(xmlFilePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

