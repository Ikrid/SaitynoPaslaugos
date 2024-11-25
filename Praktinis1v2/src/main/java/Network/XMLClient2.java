package Network;

import java.io.*;
import java.net.Socket;

/**
 * XMLClient2 klasė atsakinga už ryšį su serveriu ir XML failo siuntimą.
 *
 * Šis klientas prisijungia prie serverio ir siunčia XML failą.
 */
public class XMLClient2 {

    /** Serverio adresas. */
    private static final String SERVER_ADDRESS = "localhost";

    /** Serverio prievadas. */
    private static final int SERVER_PORT = 1234;

    /**
     * Pagrindinis metodas, paleidžiantis klientą.
     * Prisijungia prie serverio ir siunčia XML failą.
     *
     * @param args komandinės eilutės argumentai (nėra naudojami šiame projekte).
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to the server");

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Kelias iki siunčiamo XML failo
            String filePath = "src/main/resources/library.xml";

            sendXMLFile(writer, filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Siunčia XML failą serveriui per pateiktą `PrintWriter` objektą.
     *
     * @param writer PrintWriter objektas, naudojamas duomenų siuntimui.
     * @param filePath XML failo kelias, kuris bus siunčiamas.
     */
    private static void sendXMLFile(PrintWriter writer, String filePath) {
        File xmlFile = new File(filePath);

        // Tikriname, ar failas egzistuoja
        if (!xmlFile.exists()) {
            System.err.println("The file " + filePath + " does not exist.");
            return;
        }

        // Tikriname, ar kelias nėra katalogas
        if (xmlFile.isDirectory()) {
            System.err.println("The path " + filePath + " is a directory.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(xmlFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                writer.println(line); // Siunčiame kiekvieną eilutę serveriui
                System.out.println("Sending: " + line); // Rodo siunčiamą eilutę (naudinga derinimui)
            }
            System.out.println("XML failas sėkmingai išsiųstas.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

