package com.example.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import javax.persistence.*;

/**
 * Task klasė reprezentuoja užduotį, kurią galima saugoti duomenų bazėje.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    /**
     * Užduoties unikalus identifikatorius.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Užduoties pavadinimas.
     */
    private String title;

    /**
     * Užduoties aprašymas.
     */
    private String description;

    /**
     * Užduoties užbaigtumo būsena.
     * Pagal nutylėjimą priskiriama reikšmė `false`.
     */
    private boolean completed = false;

    /**
     * Užduoties galutinė įvykdymo data.
     */
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    /**
     * Nustato užduoties unikalų identifikatorių.
     *
     * @param id užduoties ID reikšmė.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Grąžina užduoties pavadinimą.
     *
     * @return užduoties pavadinimas.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Nustato užduoties pavadinimą.
     *
     * @param title užduoties pavadinimas.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Grąžina užduoties aprašymą.
     *
     * @return užduoties aprašymas.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Nustato užduoties aprašymą.
     *
     * @param description užduoties aprašymas.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
