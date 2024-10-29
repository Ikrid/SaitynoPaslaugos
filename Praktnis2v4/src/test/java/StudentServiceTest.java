import org.example.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class StudentServiceTest {
    @Test
    public void testGetStudents() {
        StudentServiceImpl service = new StudentServiceImpl();
        Assert.assertEquals(2, service.getStudents().size());
    }
}