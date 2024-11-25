package Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * XMLServer2 klasė atsakinga už serverio veikimą.
 * Šis serveris klausosi kliento užklausų ir priima XML failą.
 */
public class XMLServer2 {

    /**
     * Pagrindinis metodas, paleidžiantis serverį.
     * Serveris klausosi 1234 prievade, priima kliento ryšį ir priima XML failą.
     *
     * @param args komandinės eilutės argumentai (nėra naudojami šiame projekte).
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234");
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            receiveXMLFile(reader);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Priima XML failą iš kliento ir išsaugo jį kaip 'received_library.xml'.
     *
     * @param reader BufferedReader objektas, naudojamas duomenims skaityti iš kliento.
     */
    private static void receiveXMLFile(BufferedReader reader) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("received_library.xml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bw.write(line);
                System.out.println("Receiving: " + line); // Rodo, kas buvo gauta
            }
            System.out.println("XML failas sėkmingai gautas ir išsaugotas kaip 'received_library.xml'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


