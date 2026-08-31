import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/medicalsystem";
        String username = "root";
        String password = "nihal@raj#2026!";

        try {
            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

            connection.close();

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
