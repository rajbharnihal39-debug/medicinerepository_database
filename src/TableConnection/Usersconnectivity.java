package TableConnection;

import AllConstructor.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usersconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";

    
    // INSERT
    
    public void insertuser(Users user) {

        String sql = """
                INSERT INTO users
                (role_id, name, email, password_hash, status)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement preparedStatement =connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    user.getRoleId()
            );

            preparedStatement.setString(
                    2,
                    user.getName()
            );

            preparedStatement.setString(
                    3,
                    user.getEmail()
            );

            preparedStatement.setString(
                    4,
                    user.getPasswordHash()
            );

            preparedStatement.setString(
                    5,
                    user.getStatus()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "User creation successful"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or user insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // UPDATE
    // =========================

    public void updateuser(Users user) {

        String sql = """
                UPDATE users
                SET role_id = ?,
                    name = ?,
                    email = ?,
                    password_hash = ?,
                    status = ?
                WHERE user_id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url, username, password);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    user.getRoleId()
            );

            preparedStatement.setString(
                    2,
                    user.getName()
            );

            preparedStatement.setString(
                    3,
                    user.getEmail()
            );

            preparedStatement.setString(
                    4,
                    user.getPasswordHash()
            );

            preparedStatement.setString(
                    5,
                    user.getStatus()
            );

            preparedStatement.setInt(
                    6,
                    user.getUserId()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "User update successful"
                );

            } else {

                System.out.println(
                        "No user found with user_id: "
                                + user.getUserId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // DELETE
    // =========================

    public void deleteuser(int userId) {

        String sql = """
                DELETE FROM users
                WHERE user_id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url, username, password);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    userId
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "User delete successful"
                );

            } else {

                System.out.println(
                        "No user found with user_id: "
                                + userId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // GET ALL USERS
    // =========================

    public void getallusers() {

        String sql = """
                SELECT user_id,
                       role_id,
                       name,
                       email,
                       password_hash,
                       status,
                       created_at
                FROM users
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url, username, password);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                int userId =
                        resultSet.getInt("user_id");

                int roleId =
                        resultSet.getInt("role_id");

                String name =
                        resultSet.getString("name");

                String email =
                        resultSet.getString("email");

                String passwordHash =
                        resultSet.getString("password_hash");

                String status =
                        resultSet.getString("status");

                java.time.LocalDateTime createdAt = null;

                if (resultSet.getTimestamp("created_at") != null) {

                    createdAt =
                            resultSet.getTimestamp("created_at")
                                    .toLocalDateTime();
                }

                Users user = new Users(
                        userId,
                        roleId,
                        name,
                        email,
                        passwordHash,
                        status,
                        createdAt
                );

                System.out.println(user);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all users failed."
            );

            e.printStackTrace();
        }
    }
}
