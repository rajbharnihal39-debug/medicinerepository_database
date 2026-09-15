package TableConnection;

import AllConstructor.Sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Salesconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT
    // =========================================================

    public void insertsale(Sales sale) {

        String sql = """
                INSERT INTO sales
                (invoice_number,
                 customer_name,
                 sale_date,
                 subtotal,
                 tax,
                 discount,
                 total_amount,
                 payment_method,
                 status,
                 created_by)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url, username, password);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    sale.getInvoiceNumber()
            );

            preparedStatement.setString(
                    2,
                    sale.getCustomerName()
            );

            if (sale.getSaleDate() != null) {

                preparedStatement.setTimestamp(
                        3,
                        Timestamp.valueOf(
                                sale.getSaleDate()
                        )
                );

            } else {

                preparedStatement.setTimestamp(
                        3,
                        null
                );
            }

            preparedStatement.setDouble(
                    4,
                    sale.getSubtotal()
            );

            preparedStatement.setDouble(
                    5,
                    sale.getTax()
            );

            preparedStatement.setDouble(
                    6,
                    sale.getDiscount()
            );

            preparedStatement.setDouble(
                    7,
                    sale.getTotalAmount()
            );

            preparedStatement.setString(
                    8,
                    sale.getPaymentMethod()
            );

            preparedStatement.setString(
                    9,
                    sale.getStatus()
            );

            preparedStatement.setInt(
                    10,
                    sale.getCreatedBy()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Sale creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or sale insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public void updatesale(Sales sale) {

        String sql = """
                UPDATE sales
                SET invoice_number = ?,
                    customer_name = ?,
                    sale_date = ?,
                    subtotal = ?,
                    tax = ?,
                    discount = ?,
                    total_amount = ?,
                    payment_method = ?,
                    status = ?,
                    created_by = ?
                WHERE sale_id = ?
                """;

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url, username, password);

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    sale.getInvoiceNumber()
            );

            preparedStatement.setString(
                    2,
                    sale.getCustomerName()
            );

            if (sale.getSaleDate() != null) {

                preparedStatement.setTimestamp(
                        3,
                        Timestamp.valueOf(
                                sale.getSaleDate()
                        )
                );

            } else {

                preparedStatement.setTimestamp(
                        3,
                        null
                );
            }

            preparedStatement.setDouble(
                    4,
                    sale.getSubtotal()
            );

            preparedStatement.setDouble(
                    5,
                    sale.getTax()
            );

            preparedStatement.setDouble(
                    6,
                    sale.getDiscount()
            );

            preparedStatement.setDouble(
                    7,
                    sale.getTotalAmount()
            );

            preparedStatement.setString(
                    8,
                    sale.getPaymentMethod()
            );

            preparedStatement.setString(
                    9,
                    sale.getStatus()
            );

            preparedStatement.setInt(
                    10,
                    sale.getCreatedBy()
            );

            preparedStatement.setInt(
                    11,
                    sale.getSaleId()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Sale update successful"
                );

            } else {

                System.out.println(
                        "No sale found with sale_id: "
                                + sale.getSaleId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database sale update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public void deletesale(int saleId) {

        String sql = """
                DELETE FROM sales
                WHERE sale_id = ?
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
                    saleId
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Sale delete successful"
                );

            } else {

                System.out.println(
                        "No sale found with sale_id: "
                                + saleId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database sale delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL SALES
    // =========================================================

    public void getallsales() {

        String sql = """
                SELECT sale_id,
                       invoice_number,
                       customer_name,
                       sale_date,
                       subtotal,
                       tax,
                       discount,
                       total_amount,
                       payment_method,
                       status,
                       created_by
                FROM sales
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

                int saleId =
                        resultSet.getInt(
                                "sale_id"
                        );

                String invoiceNumber =
                        resultSet.getString(
                                "invoice_number"
                        );

                String customerName =
                        resultSet.getString(
                                "customer_name"
                        );

                LocalDateTime saleDate = null;

                if (resultSet.getTimestamp(
                        "sale_date"
                ) != null) {

                    saleDate =
                            resultSet.getTimestamp(
                                    "sale_date"
                            ).toLocalDateTime();
                }

                double subtotal =
                        resultSet.getDouble(
                                "subtotal"
                        );

                double tax =
                        resultSet.getDouble(
                                "tax"
                        );

                double discount =
                        resultSet.getDouble(
                                "discount"
                        );

                double totalAmount =
                        resultSet.getDouble(
                                "total_amount"
                        );

                String paymentMethod =
                        resultSet.getString(
                                "payment_method"
                        );

                String status =
                        resultSet.getString(
                                "status"
                        );

                int createdBy =
                        resultSet.getInt(
                                "created_by"
                        );


                Sales sale =
                        new Sales(
                                saleId,
                                invoiceNumber,
                                customerName,
                                saleDate,
                                subtotal,
                                tax,
                                discount,
                                totalAmount,
                                paymentMethod,
                                status,
                                createdBy
                        );


                System.out.println(sale);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all sales failed."
            );

            e.printStackTrace();
        }
    }
}
