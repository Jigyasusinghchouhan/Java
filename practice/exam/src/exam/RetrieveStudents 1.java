import java.sql.*;

public class RetrieveStudents {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student"; // Replace with your database URL
        String username = "root"; // Replace with your username
        String password = "root"; // Replace with your password

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM students WHERE percentage < 50";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                float percentage = rs.getFloat("percentage");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Percentage: " + percentage);
                System.out.println("--------------------------");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}