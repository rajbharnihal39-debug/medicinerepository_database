package TableConnection;

import AllConstructor.Saleitems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Saleitemsconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT
    // sale_item_id is AUTO_INCREMENT, so do not insert it
    // =========================================================

    public void insertsaleitem(Saleitems item) {

        String sql = """
                INSERT INTO sale_items
                (sale_id,
                 medicine_id,
                 batch_id,
                 quantity,
                 unit_price,
                 discount,
                 tax,
                 total_amount)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
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
                    item.getSaleId()
            );

            preparedStatement.setInt(
                    2,
                    item.getMedicineId()
            );

            preparedStatement.setInt(
                    3,
                    item.getBatchId()
            );

            preparedStatement.setInt(
                    4,
                    item.getQuantity()
            );

            preparedStatement.setDouble(
                    5,
                    item.getUnitPrice()
            );

            preparedStatement.setDouble(
                    6,
                    item.getDiscount()
            );

            preparedStatement.setDouble(
                    7,
                    item.getTax()
            );

            preparedStatement.setDouble(
                    8,
                    item.getTotalAmount()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Sale item creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or sale item insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public void updatesaleitem(Saleitems item) {

        String sql = """
                UPDATE sale_items
                SET sale_id = ?,
                    medicine_id = ?,
                    batch_id = ?,
                    quantity = ?,
                    unit_price = ?,
                    discount = ?,
                    tax = ?,
                    total_amount = ?
                WHERE sale_item_id = ?
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
                    item.getSaleId()
            );

            preparedStatement.setInt(
                    2,
                    item.getMedicineId()
            );

            preparedStatement.setInt(
                    3,
                    item.getBatchId()
            );

            preparedStatement.setInt(
                    4,
                    item.getQuantity()
            );

            preparedStatement.setDouble(
                    5,
                    item.getUnitPrice()
            );

            preparedStatement.setDouble(
                    6,
                    item.getDiscount()
            );

            preparedStatement.setDouble(
                    7,
                    item.getTax()
            );

            preparedStatement.setDouble(
                    8,
                    item.getTotalAmount()
            );

            preparedStatement.setInt(
                    9,
                    item.getSaleItemId()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Sale item update successful"
                );

            } else {

                System.out.println(
                        "No sale item found with sale_item_id: "
                                + item.getSaleItemId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Sale item update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public void deletesaleitem(int saleItemId) {

        String sql = """
                DELETE FROM sale_items
                WHERE sale_item_id = ?
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
                    saleItemId
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Sale item delete successful"
                );

            } else {

                System.out.println(
                        "No sale item found with sale_item_id: "
                                + saleItemId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Sale item delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL SALE ITEMS
    // =========================================================

    public void getallsaleitems() {

        String sql = """
                SELECT sale_item_id,
                       sale_id,
                       medicine_id,
                       batch_id,
                       quantity,
                       unit_price,
                       discount,
                       tax,
                       total_amount
                FROM sale_items
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

                int saleItemId =
                        resultSet.getInt(
                                "sale_item_id"
                        );

                int saleId =
                        resultSet.getInt(
                                "sale_id"
                        );

                int medicineId =
                        resultSet.getInt(
                                "medicine_id"
                        );

                int batchId =
                        resultSet.getInt(
                                "batch_id"
                        );

                int quantity =
                        resultSet.getInt(
                                "quantity"
                        );

                double unitPrice =
                        resultSet.getDouble(
                                "unit_price"
                        );

                double discount =
                        resultSet.getDouble(
                                "discount"
                        );

                double tax =
                        resultSet.getDouble(
                                "tax"
                        );

                double totalAmount =
                        resultSet.getDouble(
                                "total_amount"
                        );


                Saleitems item =
                        new Saleitems(
                                saleItemId,
                                saleId,
                                medicineId,
                                batchId,
                                quantity,
                                unitPrice,
                                discount,
                                tax,
                                totalAmount
                        );


                System.out.println(item);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all sale items failed."
            );

            e.printStackTrace();
        }
    }
}
