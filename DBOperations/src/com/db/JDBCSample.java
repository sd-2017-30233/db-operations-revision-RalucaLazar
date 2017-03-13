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

                        break;
                    case 2:  //Perform select #2

                        break;
                    case 3:  //Perform select #3

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
}

