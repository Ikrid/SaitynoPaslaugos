package Model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Book klasė, reprezentuojanti knygos objektą.
 * Ši klasė naudojama bibliotekos sistemoje knygų informacijai saugoti.
 */
public class Book {

    /** Knygos ISBN kodas. */
    private String isbn;

    /** Knygos pavadinimas. */
    private String title;

    /** Knygos autorius. */
    private String author;

    /** Knygos publikavimo metai. */
    private int publishedYear;

    /** Prieinamų kopijų skaičius bibliotekoje. */
    private int availableCopies;

    /**
     * Grąžina knygos ISBN kodą.
     *
     * @return knygos ISBN kodas.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Nustato knygos ISBN kodą.
     *
     * @param isbn knygos ISBN kodas.
     */
    @XmlElement
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Grąžina knygos pavadinimą.
     *
     * @return knygos pavadinimas.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Nustato knygos pavadinimą.
     *
     * @param title knygos pavadinimas.
     */
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Grąžina knygos autorių.
     *
     * @return knygos autorius.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Nustato knygos autorių.
     *
     * @param author knygos autorius.
     */
    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Grąžina knygos publikavimo metus.
     *
     * @return knygos publikavimo metai.
     */
    public int getPublishedYear() {
        return publishedYear;
    }

    /**
     * Nustato knygos publikavimo metus.
     *
     * @param publishedYear knygos publikavimo metai.
     */
    @XmlElement
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    /**
     * Grąžina prieinamų kopijų skaičių.
     *
     * @return prieinamų kopijų skaičius.
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Nustato prieinamų kopijų skaičių.
     *
     * @param availableCopies prieinamų kopijų skaičius.
     */
    @XmlElement
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}

