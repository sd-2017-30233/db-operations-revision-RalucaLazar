import java.sql.*;
import java.util.*;

/**
 * Created by Raluca on 11.03.2017.
 */
public class JDBC {

    public static String url = "jdbc:mysql://localhost/university";
    public static Connection conn;

    public JDBC(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("Successfully connected to database");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
	 * @post id != -1
	*/
    public static void addStudent(Connection conn,Student st) throws SQLException {
        Statement stmt = conn.createStatement();
        int id = -1;

        stmt.executeUpdate("insert into student(name,birth,address) values ('"+st.getName()+"','"+st.getBirth()+"','"+st.getAddress()+"')");

        //for test//
        ResultSet rs = stmt.executeQuery("select id from student where name= '"+st.getName()+"';");
        while(rs.next()) {
            id = rs.getInt(1);
        }
        assert id !=-1;
    }

    /*
     * @post id == -1
    */
    public static void removeStudent(Connection conn,int idStudent) throws SQLException {
        int id_enrollment = 0;
        int id = -1;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from student where id = "+idStudent+";");
        while(rs.next()) {
            System.out.println("Student " + rs.getString(1) + " removed.");
        }

        stmt.executeUpdate("delete from enrollment where student_id = "+idStudent+";");
        stmt.executeUpdate("delete from student where id = "+idStudent+";");

        //for test//
        rs = stmt.executeQuery("select * from student where id= '"+idStudent+"';");
        while(rs.next()) {
            id = rs.getInt(1);
        }
        assert id == -1;
    }


    public static void updateStudent(Connection conn,Student s) throws SQLException {
        Statement stmt = conn.createStatement();
        String oldName="";
        String oldBirth="";
        String oldAddr="";

        //for test//
        ResultSet rs = stmt.executeQuery("select * from student where id= '"+s.getId()+"';");
        while(rs.next()) {
            oldName = rs.getString(2);
            oldBirth = rs.getDate(3).toString();
            oldAddr = rs.getString(4);
        }

        stmt.executeUpdate("update student set name='"+s.getName()+"',birth='"+s.getBirth()+"',address='"+s.getAddress()+"' where id = "+s.getId()+";");

        assert oldName!=s.getName();
        assert oldBirth!=s.getBirth();
        assert oldAddr!=s.getAddress();
    }

        /*
        * @post id != -1
        */
        public static void addCourse(Connection conn,Course c) throws SQLException {
            Statement stmt = conn.createStatement();
            int id = -1;

            stmt.executeUpdate("insert into course(name,teacher,year) values ('"+c.getName()+"','"+c.getTeacher()+"','"+c.getYear()+"')");

            //for test//
            ResultSet rs = stmt.executeQuery("select id from course where name= '"+c.getName()+"';");
            while(rs.next()) {
                id = rs.getInt(1);
            }
            assert id !=-1;
    }

    /*
    * @post idc = -1
    */
    public static void removeCourse(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from course where id = "+id+";");
        int idc = -1;
        while(rs.next()) {
            System.out.println("Course " + rs.getString(1) + " removed.");
        }

        stmt.executeUpdate("delete from enrollment where course_id = "+id+";");
        stmt.executeUpdate("delete from course where id = "+id+";");

        //for test//
        rs = stmt.executeQuery("select * from course where id= '"+id+"';");
        while(rs.next()) {
            idc = rs.getInt(1);
        }
        assert idc == -1;
    }

    public static void updateCourse(Connection conn,Course c) throws SQLException {
        Statement stmt = conn.createStatement();

        Scanner sc = new Scanner(System.in);

        System.out.println("Modify name to: ");
        String name = sc.nextLine();
        System.out.println("Modify teacher name to: ");
        String teacher = sc.nextLine();
        System.out.println("Modify year to: ");
        int year = sc.nextInt();

        stmt.executeUpdate("update course set name='"+name+"',teacher='"+teacher+"',year='"+year+"' where id = "+c.getId()+";");

        c.setName(name);
        c.setTeacher(teacher);
        c.setYear(year);

    }

    public static void enroll(Connection conn,Student s,Course c) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from student where id = "+s.getId()+";");
        while(rs.next()) {
            System.out.print("Student " + rs.getString(1) + " enrolled to course ");
        }
        rs = stmt.executeQuery("select name from course where id = "+c.getId()+";");
        while(rs.next()) {
            System.out.println(rs.getString(1) + ".");
        }
        stmt.executeUpdate("insert into enrollment(student_id,course_id) values ("+s.getId()+","+c.getId()+")");
    }

    public static void viewStudentInfo(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from student where id = "+id+";");
        Student s = new Student();
        while(rs.next()) {
            String name = rs.getString(2);
            String birth = rs.getDate(3).toString();
            String addr = rs.getString(4);
            s.setId(id);
            s.setName(name);
            s.setBirth(birth);
            s.setAddress(addr);
        }
        System.out.println(s.toString());
    }

    public static void viewCourseInfo(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from course where id = "+id+";");
        Course c = new Course();
        while(rs.next()) {
            String name = rs.getString(2);
            String teacher = rs.getString(3);
            int year = rs.getInt(4);
            c.setId(id);
            c.setName(name);
            c.setTeacher(teacher);
            c.setYear(year);
        }
        System.out.println(c.toString());
    }

    public static void enrolledToCourse(Connection conn,int id) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from enrollment, student where course_id = "+id+" and student_id = student.id;");
        while(rs.next()) {
            int ids = rs.getInt(4);
            String name = rs.getString(5);
            String birth = rs.getDate(6).toString();
            String addr = rs.getString(7);
            System.out.println(ids+"."+name+" | "+birth+" | "+addr);
        }
    }

    }
