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

            // Provide the correct path to student.xml
            String filePath = "path/to/student.xml"; // Use an actual path here.

            // Sending XML file
            sendXMLFile(writer, filePath);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendXMLFile(PrintWriter writer, String filePath) {
        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            System.err.println("The file " + filePath + " does not exist. Creating a default student.xml for demonstration purposes.");

            // Ensure the directory exists
            File parentDir = xmlFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Created directories: " + parentDir.getPath());
                } else {
                    System.err.println("Failed to create directories: " + parentDir.getPath());
                    return;
                }
            }

            // Create a default student.xml
            try (PrintWriter fileWriter = new PrintWriter(new FileWriter(xmlFile))) {
                fileWriter.println("<students>");
                fileWriter.println("    <student>");
                fileWriter.println("        <name>John Doe</name>");
                fileWriter.println("        <age>21</age>");
                fileWriter.println("        <major>Computer Science</major>");
                fileWriter.println("    </student>");
                fileWriter.println("</students>");
                System.out.println("Default student.xml created.");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        if (xmlFile.isDirectory()) {
            System.err.println("The path " + filePath + " is a directory.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(xmlFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                writer.println(line);  // Send each line to the client
                System.out.println("Sending: " + line); // Output what is being sent
            }
            System.out.println("XML file sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}