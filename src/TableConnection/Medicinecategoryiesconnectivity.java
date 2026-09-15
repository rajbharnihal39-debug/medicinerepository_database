package TableConnection;

import AllConstructor.Medicinecategories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicinecategoryiesconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    
    // INSERT
    
    public void insertmedicinecategories(
            Medicinecategories medicinecategories) {

        String sql = """
                INSERT INTO medicine_categories
                (category_id, category_name, description)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement =connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1,medicinecategories.getId());

            preparedStatement.setString(2,medicinecategories.getCategoryName());

            preparedStatement.setString(3,medicinecategories.getDescription());

            int rowaffected =preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println("Medicine category creation successful");

            }

        } catch (SQLException e) {

            System.out.println("Database connection or medicine category insert failed");

            e.printStackTrace();
        }
    }


    
    // UPDATE
    

    public void updatemedicinecategories(
            Medicinecategories medicinecategories) {

        String sql = """
                UPDATE medicine_categories
                SET category_name = ?,
                    description = ?
                WHERE category_id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1,medicinecategories.getCategoryName());

            preparedStatement.setString(2,medicinecategories.getDescription());

            preparedStatement.setInt(3,medicinecategories.getId());

            int rowaffected = preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println("Medicine category update successful"
                );

            } /*else {

                System.out.println("No medicine category found with category_id: "+ medicinecategories.getId()
                );
            } */

        } catch (SQLException e) {

            System.out.println("Database medicine category update failed");

            e.printStackTrace();
        }
    }


    
    // DELETE
    

    public void deletemedicinecategories(int categoryId) {

        String sql = """
                DELETE FROM medicine_categories
                WHERE category_id = ?
                """;

        try (
                Connection connection =DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement =connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1,categoryId);

            int rowaffected =preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println("Medicine category delete successful");

            } 

        } catch (SQLException e) {

            System.out.println("Database medicine category delete failed");

            e.printStackTrace();
        }
    }


    
    // GET ALL
    

    public void getallmedicinecategories() {

        String sql = """
                SELECT category_id,
                       category_name,
                       description
                FROM medicine_categories
                """;

        try (
                Connection connection =DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement =connection.prepareStatement(sql);

                ResultSet resultSet =preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                int categoryId =resultSet.getInt("category_id");

                String categoryName =resultSet.getString("category_name");

                String description =resultSet.getString("description");


                Medicinecategories medicinecategories =new Medicinecategories();

                medicinecategories.setId(categoryId);

                medicinecategories.setCategoryName(categoryName);

                medicinecategories.setDescription(description);


                System.out.println(medicinecategories);

                System.out.println("-------------------------");
            }

        } catch (SQLException e) {

            System.out.println("Get all medicine categories failed."
            );

            e.printStackTrace();
        }
    }
}
