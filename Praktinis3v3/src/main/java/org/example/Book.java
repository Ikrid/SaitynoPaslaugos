package org.example;

/**
 * Klasė, reprezentuojanti knygą.
 */
public class Book {
    private String title;
    private int pages;

    /**
     * Tuščias konstruktorius.
     */
    public Book() {}

    /**
     * Konstruktorius su parametrais.
     *
     * @param title knygos pavadinimas
     * @param pages puslapių skaičius
     */
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    // Getters ir Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
