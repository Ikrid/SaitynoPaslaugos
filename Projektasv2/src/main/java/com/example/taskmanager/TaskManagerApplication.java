package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Pagrindinė Spring Boot programos TaskManagerApplication klasė.
 * Ši klasė paleidžia Task Manager programą.
 */
@SpringBootApplication
public class TaskManagerApplication {

    /**
     * Pagrindinis metodas, kuris paleidžia Spring Boot programą.
     *
     * @param args programos argumentai.
     */
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}
