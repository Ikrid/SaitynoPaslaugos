package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;


@Path("/students")
public class StudentService {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1,"Adam", 20, 3.5f, true, 'A', List.of(new Subject("Math", 4))));
        students.add(new Student(2,"Inesa", 22, 4.0f, true, 'B', List.of(new Subject("Science", 5))));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") int id) {
        return students.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        return students;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return Response.ok("Student deleted successfully").build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Student not found").build();
    }
}
