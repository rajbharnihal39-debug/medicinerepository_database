package TableConnection;

import AllConstructor.Purchaseorderitems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Purchaseorderitemsconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT
    // =========================================================

    public void insertpurchaseorderitem(Purchaseorderitems item) {

        String sql = """
                INSERT INTO purchase_order_items
                (purchase_order_id,
                 medicine_id,
                 quantity_ordered,
                 unit_price,
                 tax,
                 discount,
                 total_amount)
                VALUES (?, ?, ?, ?, ?, ?, ?)
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
                    item.getPurchaseOrderId()
            );

            preparedStatement.setInt(
                    2,
                    item.getMedicineId()
            );

            preparedStatement.setInt(
                    3,
                    item.getQuantityOrdered()
            );

            preparedStatement.setDouble(
                    4,
                    item.getUnitPrice()
            );

            preparedStatement.setDouble(
                    5,
                    item.getTax()
            );

            preparedStatement.setDouble(
                    6,
                    item.getDiscount()
            );

            preparedStatement.setDouble(
                    7,
                    item.getTotalAmount()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Purchase order item creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or purchase order item insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public void updatepurchaseorderitem(
            Purchaseorderitems item) {

        String sql = """
                UPDATE purchase_order_items
                SET purchase_order_id = ?,
                    medicine_id = ?,
                    quantity_ordered = ?,
                    unit_price = ?,
                    tax = ?,
                    discount = ?,
                    total_amount = ?
                WHERE po_item_id = ?
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
                    item.getPurchaseOrderId()
            );

            preparedStatement.setInt(
                    2,
                    item.getMedicineId()
            );

            preparedStatement.setInt(
                    3,
                    item.getQuantityOrdered()
            );

            preparedStatement.setDouble(
                    4,
                    item.getUnitPrice()
            );

            preparedStatement.setDouble(
                    5,
                    item.getTax()
            );

            preparedStatement.setDouble(
                    6,
                    item.getDiscount()
            );

            preparedStatement.setDouble(
                    7,
                    item.getTotalAmount()
            );

            preparedStatement.setInt(
                    8,
                    item.getPoItemId()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Purchase order item update successful"
                );

            } else {

                System.out.println(
                        "No purchase order item found with ID: "
                                + item.getPoItemId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Purchase order item update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public void deletepurchaseorderitem(
            int poItemId) {

        String sql = """
                DELETE FROM purchase_order_items
                WHERE po_item_id = ?
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
                    poItemId
            );


            int rowaffected =
                    preparedStatement.executeUpdate();


            if (rowaffected == 1) {

                System.out.println(
                        "Purchase order item delete successful"
                );

            } else {

                System.out.println(
                        "No purchase order item found with ID: "
                                + poItemId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Purchase order item delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL PURCHASE ORDER ITEMS
    // =========================================================

    public void getallpurchaseorderitems() {

        String sql = """
                SELECT po_item_id,
                       purchase_order_id,
                       medicine_id,
                       quantity_ordered,
                       unit_price,
                       tax,
                       discount,
                       total_amount
                FROM purchase_order_items
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

                int poItemId =
                        resultSet.getInt(
                                "po_item_id"
                        );

                int purchaseOrderId =
                        resultSet.getInt(
                                "purchase_order_id"
                        );

                int medicineId =
                        resultSet.getInt(
                                "medicine_id"
                        );

                int quantityOrdered =
                        resultSet.getInt(
                                "quantity_ordered"
                        );

                double unitPrice =
                        resultSet.getDouble(
                                "unit_price"
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


                Purchaseorderitems item =
                        new Purchaseorderitems(
                                poItemId,
                                purchaseOrderId,
                                medicineId,
                                quantityOrdered,
                                unitPrice,
                                tax,
                                discount,
                                totalAmount
                        );


                System.out.println(item);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all purchase order items failed."
            );

            e.printStackTrace();
        }
    }
}
