package Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class XMLServer2 {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234");
            Socket socket = serverSocket.accept();

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Укажите реальный путь к файлу student.xml
            String filePath = "src/main/resources/student.xml"; // Замените на реальный путь

            // Отправка XML-файла
            sendXMLFile(writer, filePath);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendXMLFile(PrintWriter writer, String filePath) {
        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            System.err.println("The file " + filePath + " does not exist.");
            return;
        }

        if (xmlFile.isDirectory()) {
            System.err.println("The path " + filePath + " is a directory.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(xmlFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                writer.println(line);  // Отправляем каждую строку клиенту
                System.out.println("Sending: " + line); // Для отладки выводим отправляемую строку
            }
            System.out.println("XML file sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
