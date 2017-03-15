import org.junit.Test;


/**
 * Created by Raluca on 15.03.2017.
 */
public class JDBCSampleTest {

    @Test
    public void addStudent() throws Exception {

        JDBC j = new JDBC();
        Student s = new Student();
        s.setName("Florina");
        s.setBirth("1995-03-24");
        s.setAddress("Fantanele, 57");
        j.addStudent(j.conn,s);
    }

    @Test
    public void removeStudent() throws Exception {
        JDBC j = new JDBC();
        j.removeStudent(j.conn,2);
    }

    @Test
    public void updateStudent() throws Exception {
        JDBC j = new JDBC();
        Student s = new Student();
        s.setId(1);
        s.setName("Raluca Florina");
        s.setBirth("1990-03-24");
        s.setAddress("Fantanele, 60");
        j.updateStudent(j.conn,s);
    }

    @Test
    public void addCourse() throws Exception {
        JDBC j = new JDBC();
        Course c = new Course();
        c.setName("Intelligent Systems");
        c.setTeacher("A. Groza");
        c.setYear(3);
        j.addCourse(j.conn,c);
    }

    @Test
    public void removeCourse() throws Exception {
        JDBC j = new JDBC();
        j.removeCourse(j.conn,3);
    }

}