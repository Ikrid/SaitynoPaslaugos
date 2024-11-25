package org.example;

import Model.Library;
import Transform.XMLTransformer;

/**
 * Main klasė, paleidžianti programą.
 * Ši klasė demonstruoja XML failo transformavimą į POJO objektą.
 */
public class Main {

    /**
     * Pagrindinis metodas, kuris paleidžia programą.
     * Naudoja XMLTransformer, kad perskaitytų XML failą ir konvertuotų jį į Library objektą.
     *
     * @param args komandinės eilutės argumentai (nėra naudojami šiame projekte).
     */
    public static void main(String[] args) {

        // Sukuriame XMLTransformer objektą XML konvertavimui
        XMLTransformer transformer = new XMLTransformer();

        // Transformuojame XML failą į Library objektą
        Library library = transformer.transformToPOJO("received_library.xml");

        // Tikriname, ar objektas sėkmingai sukurtas, ir spausdiname jo duomenis
        if (library != null) {
            System.out.println("Library Name: " + library.getLibraryName());
            System.out.println("Address: " + library.getAddress());
            System.out.println("Books:");

            // Spaudiname visų knygų informaciją
            library.getBooks().forEach(book -> {
                System.out.println("  - ISBN: " + book.getIsbn());
                System.out.println("    Title: " + book.getTitle());
                System.out.println("    Author: " + book.getAuthor());
                System.out.println("    Published Year: " + book.getPublishedYear());
                System.out.println("    Available Copies: " + book.getAvailableCopies());
            });
        } else {
            System.out.println("Failed to convert XML to POJO.");
        }
    }
}

