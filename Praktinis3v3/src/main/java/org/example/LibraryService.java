package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * REST paslaugų klasė, skirta bibliotekos operacijoms.
 */
@Path("/libraries")
public class LibraryService {

    private static List<Library> libraries = new ArrayList<>();

    static {
        libraries.add(new Library(1, "Centrinė biblioteka", 1990, 4.5f, true, 'A', List.of(new Book("Java pradedantiesiems", 300))));
        libraries.add(new Library(2, "Miestelio biblioteka", 1985, 4.0f, true, 'B', List.of(new Book("Duomenų struktūros", 500))));
    }

    /**
     * Gauti biblioteką pagal ID.
     *
     * @param id bibliotekos identifikatorius
     * @return rasta biblioteka
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Library getLibraryById(@PathParam("id") int id) {
        return libraries.get(id);
    }

    /**
     * Sukurti naują biblioteką.
     *
     * @param library nauja biblioteka
     * @return sukurta biblioteka
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Library createLibrary(Library library) {
        libraries.add(library);
        return library;
    }

    /**
     * Gauti visų bibliotekų sąrašą.
     *
     * @return visų bibliotekų sąrašas
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Library> getAllLibraries() {
        return libraries;
    }

    /**
     * Ištrinti biblioteką pagal ID.
     *
     * @param id bibliotekos identifikatorius
     * @return atsakymas apie ištrynimo būseną
     */
    @DELETE
    @Path("/{id}")
    public Response deleteLibrary(@PathParam("id") int id) {
        for (Library library : libraries) {
            if (library.getId() == id) {
                libraries.remove(library);
                return Response.ok("Biblioteka sėkmingai ištrinta").build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Biblioteka nerasta").build();
    }
}

