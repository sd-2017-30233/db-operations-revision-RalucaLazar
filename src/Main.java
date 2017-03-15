import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Raluca on 11.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        int op = 0;
        String answer = "Yes";
        Scanner sc;

        try {
            while (answer.equals("Yes")) {
                System.out.println();
                System.out.println("Alegeti optiunea: ");
                System.out.println("\t1.Add student");
                System.out.println("\t2.Remove student");
                System.out.println("\t3.Update student information");
                System.out.println("\t4.Add course");
                System.out.println("\t5.Remove course");
                System.out.println("\t6.Update course information");
                System.out.println("\t7.Enroll");
                System.out.println("\t8.View student information");
                System.out.println("\t9.View course information");
                System.out.println("\t10.View list of students enrolled to a course");
                System.out.println("\t11.Exit");
                System.out.println();
                sc = new Scanner(System.in);
                op = sc.nextInt();
                switch (op) {
                    case 1:  //Perform select #1
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Name: ");
                        String name = sc1.nextLine();
                        System.out.println("Birth date: ");
                        String date = sc1.nextLine();
                        System.out.println("Address: ");
                        String address = sc1.nextLine();
                        Student st = new Student();
                        st.setName(name);
                        st.setBirth(date);
                        st.setAddress(address);
                        jdbc.addStudent(jdbc.conn, st);
                        break;
                    case 2:  //Perform select #2
                        System.out.println("Student id: ");
                        int id = sc.nextInt();
                        jdbc.removeStudent(jdbc.conn, id);
                        break;
                    case 3:  //Perform select #3
                        Student s = new Student();
                        System.out.println("Student id: ");
                        s.setId(sc.nextInt());
                        System.out.println("Modify name to: ");
                        String name2 = sc.nextLine();
                        System.out.println("Modify birth date to: ");
                        String date2 = sc.nextLine();
                        System.out.println("Modify address to: ");
                        String address2 = sc.nextLine();
                        s.setName(name2);
                        s.setBirth(date2);
                        s.setAddress(address2);
                        jdbc.updateStudent(jdbc.conn, s);
                        break;
                    case 4:  //Perform select #4
                        Course c = new Course();
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Name: ");
                        String name1 = sc2.nextLine();
                        System.out.println("Teacher: ");
                        String teacher = sc2.nextLine();
                        System.out.println("Year: ");
                        int year = sc2.nextInt();
                        c.setName(name1);
                        c.setTeacher(teacher);
                        c.setYear(year);
                        jdbc.addCourse(jdbc.conn,c);
                        break;
                    case 5:  //Perform select #5
                        Course c1 = new Course();
                        System.out.println("Course id: ");
                        int idc = sc.nextInt();
                        jdbc.removeCourse(jdbc.conn, idc);
                        break;
                    case 6: //Perform select #6
                        Course c2 = new Course();
                        System.out.println("Course id: ");
                        c2.setId(sc.nextInt());
                        jdbc.updateCourse(jdbc.conn, c2);
                        break;
                    case 7: //Perform select #7
                        Student student = new Student();
                        Course course = new Course();
                        System.out.println("Student id: ");
                        student.setId(sc.nextInt());
                        System.out.println("Course id: ");
                        course.setId(sc.nextInt());
                        jdbc.enroll(jdbc.conn, student, course);
                        break;
                    case 8: //Perform select #8
                        System.out.println("Student id: ");
                        int id1 = sc.nextInt();
                        jdbc.viewStudentInfo(jdbc.conn, id1);
                        break;
                    case 9: //Perform select #9
                        System.out.println("Course id: ");
                        int id2 = sc.nextInt();
                        jdbc.viewCourseInfo(jdbc.conn, id2);
                        break;
                    case 10: //Perform select #10
                        System.out.println("Course id: ");
                        int id3 = sc.nextInt();
                        jdbc.enrolledToCourse(jdbc.conn, id3);
                        break;
                    case 11:  //Exit
                        System.exit(0);
                }
                System.out.println();
                System.out.println("Continue? Yes/No");
                sc = new Scanner(System.in);
                answer = sc.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jdbc.conn != null) {
                try {
                    if (!jdbc.conn.isClosed()) {
                        jdbc.conn.close();
                    }
                } catch (SQLException e) {
                }
            }
        }
    }
}