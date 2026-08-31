package TableConnection;

import AllConstructor.Stocktransactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Stocktrannsactionsconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT
    // =========================================================

    public void insertstocktransaction(
            Stocktransactions transaction) {

        String sql = """
                INSERT INTO stock_transactions
                (
                    medicine_id,
                    batch_id,
                    transaction_type,
                    quantity,
                    reference_type,
                    reference_id,
                    transaction_date,
                    notes,
                    created_by
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
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
                    transaction.getMedicineId()
            );

            preparedStatement.setInt(
                    2,
                    transaction.getBatchId()
            );

            preparedStatement.setString(
                    3,
                    transaction.getTransactionType()
            );

            preparedStatement.setInt(
                    4,
                    transaction.getQuantity()
            );

            preparedStatement.setString(
                    5,
                    transaction.getReferenceType()
            );

            preparedStatement.setInt(
                    6,
                    transaction.getReferenceId()
            );

            if (transaction.getTransactionDate() != null) {

                preparedStatement.setTimestamp(
                        7,
                        Timestamp.valueOf(
                                transaction.getTransactionDate()
                        )
                );

            } else {

                preparedStatement.setTimestamp(
                        7,
                        null
                );
            }

            preparedStatement.setString(
                    8,
                    transaction.getNotes()
            );

            preparedStatement.setInt(
                    9,
                    transaction.getCreatedBy()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Stock transaction creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or stock transaction insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public void updatestocktransaction(
            Stocktransactions transaction) {

        String sql = """
                UPDATE stock_transactions
                SET medicine_id = ?,
                    batch_id = ?,
                    transaction_type = ?,
                    quantity = ?,
                    reference_type = ?,
                    reference_id = ?,
                    transaction_date = ?,
                    notes = ?,
                    created_by = ?
                WHERE transaction_id = ?
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
                    transaction.getMedicineId()
            );

            preparedStatement.setInt(
                    2,
                    transaction.getBatchId()
            );

            preparedStatement.setString(
                    3,
                    transaction.getTransactionType()
            );

            preparedStatement.setInt(
                    4,
                    transaction.getQuantity()
            );

            preparedStatement.setString(
                    5,
                    transaction.getReferenceType()
            );

            preparedStatement.setInt(
                    6,
                    transaction.getReferenceId()
            );

            if (transaction.getTransactionDate() != null) {

                preparedStatement.setTimestamp(
                        7,
                        Timestamp.valueOf(
                                transaction.getTransactionDate()
                        )
                );

            } else {

                preparedStatement.setTimestamp(
                        7,
                        null
                );
            }

            preparedStatement.setString(
                    8,
                    transaction.getNotes()
            );

            preparedStatement.setInt(
                    9,
                    transaction.getCreatedBy()
            );

            preparedStatement.setInt(
                    10,
                    transaction.getTransactionId()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Stock transaction update successful"
                );

            } else {

                System.out.println(
                        "No stock transaction found with transaction_id: "
                                + transaction.getTransactionId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Stock transaction update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public void deletestocktransaction(
            int transactionId) {

        String sql = """
                DELETE FROM stock_transactions
                WHERE transaction_id = ?
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
                    transactionId
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Stock transaction delete successful"
                );

            } else {

                System.out.println(
                        "No stock transaction found with transaction_id: "
                                + transactionId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Stock transaction delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL STOCK TRANSACTIONS
    // =========================================================

    public void getallstocktransactions() {

        String sql = """
                SELECT transaction_id,
                       medicine_id,
                       batch_id,
                       transaction_type,
                       quantity,
                       reference_type,
                       reference_id,
                       transaction_date,
                       notes,
                       created_by
                FROM stock_transactions
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

            while (resultSet.next()) {

                int transactionId =
                        resultSet.getInt(
                                "transaction_id"
                        );

                int medicineId =
                        resultSet.getInt(
                                "medicine_id"
                        );

                int batchId =
                        resultSet.getInt(
                                "batch_id"
                        );

                String transactionType =
                        resultSet.getString(
                                "transaction_type"
                        );

                int quantity =
                        resultSet.getInt(
                                "quantity"
                        );

                String referenceType =
                        resultSet.getString(
                                "reference_type"
                        );

                int referenceId =
                        resultSet.getInt(
                                "reference_id"
                        );

                LocalDateTime transactionDate = null;

                Timestamp timestamp =
                        resultSet.getTimestamp(
                                "transaction_date"
                        );

                if (timestamp != null) {

                    transactionDate =
                            timestamp.toLocalDateTime();
                }

                String notes =
                        resultSet.getString(
                                "notes"
                        );

                int createdBy =
                        resultSet.getInt(
                                "created_by"
                        );


                Stocktransactions transaction =
                        new Stocktransactions(
                                transactionId,
                                medicineId,
                                batchId,
                                transactionType,
                                quantity,
                                referenceType,
                                referenceId,
                                transactionDate,
                                notes,
                                createdBy
                        );


                System.out.println(transaction);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all stock transactions failed."
            );

            e.printStackTrace();
        }
    }
}
