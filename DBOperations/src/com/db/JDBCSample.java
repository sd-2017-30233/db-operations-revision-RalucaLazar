package com.db;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Raluca on 11.03.2017.
 */
public class JDBCSample {

    public static void main(String[] args) {
        Connection conn = null;
        int op = 0;
        String answer = "Yes";
        Scanner sc;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/university";
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("Successfully connected to database");

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
                System.out.println("\t8.Exit");
                System.out.println();
                sc = new Scanner(System.in);
                op = sc.nextInt();
                switch (op) {
                    case 1:  //Perform select #1
                        addStudent(conn);
                        break;
                    case 2:  //Perform select #2
                        Student st = new Student();
                        System.out.println("Student id: ");
                        st.setId(sc.nextInt());
                        removeStudent(conn,st);
                        break;
                    case 3:  //Perform select #3
                        Student s = new Student();
                        System.out.println("Student id: ");
                        s.setId(sc.nextInt());
                        updateStudent(conn,s);
                        break;
                    case 4:  //Perform select #4

                        break;
                    case 5:  //Perform select #5

                        break;
                    case 6: //Perform select #6

                        break;
                    case 7: //Perform select #7

                        break;
                    case 8:  //Exit
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
            if (conn != null) {
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                }
            }
        }
    }

    public static void addStudent(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Birth date: ");
        String date = sc.nextLine();
        System.out.println("Address: ");
        String address = sc.nextLine();

        stmt.executeUpdate("insert into student(name,birth,address) values ('"+name+"','"+date+"','"+address+"')");
    }

    public static void removeStudent(Connection conn,Student st) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select name from student where id = "+st.getId()+";");
        while(rs.next()) {
            System.out.println("Student " + rs.getString(1) + " removed.");
        }
        stmt.executeUpdate("delete from student where id = "+st.getId()+";");
    }

/*
    public static void updateStudent1(Connection conn, Student s) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from student where id = "+s.getId()+";");
        ResultSet rs = stmt.executeQuery();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Modify name to: ");
        String name = sc1.nextLine();
        System.out.println("Modify birth date to: ");
        String date = sc1.nextLine();
        System.out.println("Modify address to: ");
        String address = sc1.nextLine();

        stmt.setString(2, name);
        stmt.setString(3,date);
        stmt.setString(4,address);

        s.setName(name);
        s.setBirth(date);
        s.setAddress(address);
    }
*/

    public static void updateStudent(Connection conn, Student s) throws SQLException {
        Statement stmt = conn.createStatement();

        Scanner sc = new Scanner(System.in);

        System.out.println("Modify name to: ");
        String name = sc.nextLine();
        System.out.println("Modify birth date to: ");
        String date = sc.nextLine();
        System.out.println("Modify address to: ");
        String address = sc.nextLine();

        stmt.executeUpdate("update student set name='"+name+"',birth='"+date+"',address='"+address+"' where id = "+s.getId()+";");

        s.setName(name);
        s.setBirth(date);
        s.setAddress(address);
    }

}

