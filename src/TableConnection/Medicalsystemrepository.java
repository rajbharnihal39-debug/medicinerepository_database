package TableConnection;

import AllConstructor.medicalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicalsystemrepository {

     String url ="jdbc:mysql://localhost:3306/medicalsystem";

     String username ="root";

     String password ="nihal@raj#2026!";


    // =========================================================
    // INSERT ROLE
    // =========================================================

    public void roleuser(medicalsystem medical) {

        String sql = """
                INSERT INTO roles(role_id, role_name, description)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    medical.getrole_id()
            );

            preparedStatement.setString(
                    2,
                    medical.getrole_name()
            );

            preparedStatement.setString(
                    3,
                    medical.getdescription()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Create operation successful"
                );

            } else {

                System.out.println(
                        "Role was not inserted"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE ROLE
    // =========================================================

    public void updateroleuser(medicalsystem medical) {

        String sql = """
                UPDATE roles
                SET role_name = ?,
                    description = ?
                WHERE role_id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    medical.getrole_name()
            );

            preparedStatement.setString(
                    2,
                    medical.getdescription()
            );

            preparedStatement.setInt(
                    3,
                    medical.getrole_id()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Update operation successful"
                );

            } else {

                System.out.println(
                        "No role found with role_id: "
                                + medical.getrole_id()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE ROLE
    // =========================================================

    public void deleterole(int role_id) {

        String sql = """
                DELETE FROM roles
                WHERE role_id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    role_id
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Delete operation successful"
                );

            } 

        } catch (SQLException e) {

            System.out.println(
                    "Database delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL ROLES
    // =========================================================

    public void getallroles() {

        String sql = """
                SELECT role_id, role_name, description
                FROM roles
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                username,
                                password
                        );

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                int id =
                        resultSet.getInt("role_id");

                String roleName =
                        resultSet.getString("role_name");

                String description =
                        resultSet.getString("description");

                medicalsystem medical =
                        new medicalsystem(
                                id,
                                roleName,
                                description
                        );

                System.out.println(medical);

                System.out.println(
                        "-------------------------"
                );
            }

            if (!found) {

                System.out.println(
                        "No roles found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all roles failed."
            );

            e.printStackTrace();
        }
    }
}
