package org.example;

import java.util.List;

/**
 * Klasė, reprezentuojanti biblioteką su knygų informacija.
 */
public class Library {
    private int id;
    private String name;
    private int yearEstablished;
    private float rating;
    private boolean isOpen;
    private char section;
    private List<Book> books;

    /**
     * Tuščias konstruktorius.
     */
    public Library() {}

    /**
     * Konstruktorius su parametrais.
     *
     * @param id              bibliotekos unikalus identifikatorius
     * @param name            bibliotekos pavadinimas
     * @param yearEstablished įkūrimo metai
     * @param rating          bibliotekos įvertinimas
     * @param isOpen          ar biblioteka veikia
     * @param section         bibliotekos sekcija
     * @param books           knygų sąrašas
     */
    public Library(int id, String name, int yearEstablished, float rating, boolean isOpen, char section, List<Book> books) {
        this.id = id;
        this.name = name;
        this.yearEstablished = yearEstablished;
        this.rating = rating;
        this.isOpen = isOpen;
        this.section = section;
        this.books = books;
    }

    // Getters ir Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", yearEstablished=" + yearEstablished +
                ", rating=" + rating +
                ", isOpen=" + isOpen +
                ", section=" + section +
                ", books=" + books +
                '}';
    }
}
