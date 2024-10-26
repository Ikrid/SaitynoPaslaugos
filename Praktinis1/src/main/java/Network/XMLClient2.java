package Network;

import java.io.*;
import java.net.Socket;


public class XMLClient2 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to the server");

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Получение XML-файла и сохранение его на диск
            receiveXMLFile(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveXMLFile(BufferedReader reader) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("received_student.xml"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bw.write(line);  // Записываем каждую строку в файл
                bw.newLine();    // Добавляем новую строку
                System.out.println("Receiving: " + line); // Выводим на консоль полученные данные
            }
            System.out.println("XML file received and saved as 'received_student.xml'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
