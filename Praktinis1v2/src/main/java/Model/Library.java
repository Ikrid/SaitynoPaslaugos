package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Library klasė, reprezentuojanti bibliotekos objektą.
 * Ši klasė saugo informaciją apie biblioteką, jos adresą ir knygų sąrašą.
 */
@XmlRootElement(name = "Library")
public class Library {

    /** Bibliotekos pavadinimas. */
    private String libraryName;

    /** Bibliotekos adresas. */
    private String address;

    /** Knygų, esančių bibliotekoje, sąrašas. */
    private List<Book> books;

    /**
     * Grąžina bibliotekos pavadinimą.
     *
     * @return bibliotekos pavadinimas.
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * Nustato bibliotekos pavadinimą.
     *
     * @param libraryName bibliotekos pavadinimas.
     */
    @XmlElement
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    /**
     * Grąžina bibliotekos adresą.
     *
     * @return bibliotekos adresas.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Nustato bibliotekos adresą.
     *
     * @param address bibliotekos adresas.
     */
    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Grąžina knygų, esančių bibliotekoje, sąrašą.
     *
     * @return knygų sąrašas.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Nustato knygų, esančių bibliotekoje, sąrašą.
     *
     * @param books knygų sąrašas.
     */
    @XmlElement
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

