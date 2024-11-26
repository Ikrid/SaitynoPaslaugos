package org.example;

import org.example.StudentServiceImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/studentservice", new StudentServiceImpl());
        System.out.println("Service is running...");
    }
}
