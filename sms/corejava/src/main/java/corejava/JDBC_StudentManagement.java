package corejava;

import java.sql.*;
import java.util.Scanner;

public class JDBC_StudentManagement {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydb";
    private static final String USER = "postgres";
    private static final String PASSWD = "123";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWD);
    }

    public static void createTable(String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "age INT NOT NULL, " +
                "roll_no INT UNIQUE NOT NULL, " +
                "marks DOUBLE PRECISION NOT NULL" +
                ")";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertStudent(String tableName, String name, int age, int rollNo, double marks) {
        String sql = "INSERT INTO " + tableName + " (name, age, roll_no, marks) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, rollNo);
            pstmt.setDouble(4, marks);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(String tableName, int id, String name, int age, int rollNo, double marks) {
        String sql = "UPDATE " + tableName + " SET name=?, age=?, roll_no=?, marks=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, rollNo);
            pstmt.setDouble(4, marks);
            pstmt.setInt(5, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student record updated successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent(String tableName, int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showStudents(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Name | Age | Roll No | Marks");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getInt("roll_no") + " | " +
                        rs.getDouble("marks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String tableName = "studentsdetails";
        int choice;

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Create Student Table");
            System.out.println("2. Insert Student");
            System.out.println("3. Update Student");
            System.out.println("4. Show Students");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createTable(tableName);
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Roll No: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    insertStudent(tableName, name, age, rollNo, marks);
                    break;
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter New Roll No: ");
                    int newRollNo = scanner.nextInt();
                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    updateStudent(tableName, id, newName, newAge, newRollNo, newMarks);
                    break;
                case 4:
                    showStudents(tableName);
                    break;
                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteStudent(tableName, deleteId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
            }
        }
    }
}
