package TableConnection;

import AllConstructor.Expiryalerts;

import java.time.LocalDate;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Expiryalertsconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT
    // =========================================================

    public void insertexpiryalert(Expiryalerts expiryalert) {

        String sql = """
                INSERT INTO expiry_alerts
                (batch_id, alert_type, alert_date, status)
                VALUES (?, ?, ?, ?)
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
                    expiryalert.getBatchId()
            );

            preparedStatement.setString(
                    2,
                    expiryalert.getAlertType()
            );

            preparedStatement.setDate(
                    3,
                    Date.valueOf(
                            expiryalert.getAlertDate()
                    )
            );

            preparedStatement.setString(
                    4,
                    expiryalert.getStatus()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Expiry alert creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or expiry alert insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public void updateexpiryalert(Expiryalerts expiryalert) {

        String sql = """
                UPDATE expiry_alerts
                SET batch_id = ?,
                    alert_type = ?,
                    alert_date = ?,
                    status = ?
                WHERE alert_id = ?
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
                    expiryalert.getBatchId()
            );

            preparedStatement.setString(
                    2,
                    expiryalert.getAlertType()
            );

            preparedStatement.setDate(
                    3,
                    Date.valueOf(
                            expiryalert.getAlertDate()
                    )
            );

            preparedStatement.setString(
                    4,
                    expiryalert.getStatus()
            );

            preparedStatement.setInt(
                    5,
                    expiryalert.getAlertId()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Expiry alert update successful"
                );

            } else {

                System.out.println(
                        "No expiry alert found with alert_id: "
                                + expiryalert.getAlertId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database expiry alert update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public void deleteexpiryalert(int alertId) {

        String sql = """
                DELETE FROM expiry_alerts
                WHERE alert_id = ?
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
                    alertId
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Expiry alert delete successful"
                );

            } else {

                System.out.println(
                        "No expiry alert found with alert_id: "
                                + alertId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database expiry alert delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL EXPIRY ALERTS
    // =========================================================

    public void getallexpiryalerts() {

        String sql = """
                SELECT alert_id,
                       batch_id,
                       alert_type,
                       alert_date,
                       status
                FROM expiry_alerts
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

                int alertId =
                        resultSet.getInt("alert_id");

                int batchId =
                        resultSet.getInt("batch_id");

                String alertType =
                        resultSet.getString("alert_type");

                LocalDate alertDate =
                        null;

                if (resultSet.getDate("alert_date") != null) {

                    alertDate =
                            resultSet.getDate("alert_date")
                                    .toLocalDate();
                }

                String status =
                        resultSet.getString("status");


                Expiryalerts expiryalert =
                        new Expiryalerts(
                                alertId,
                                batchId,
                                alertType,
                                alertDate,
                                status
                        );


                System.out.println(
                        expiryalert
                );

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all expiry alerts failed."
            );

            e.printStackTrace();
        }
    }
}
