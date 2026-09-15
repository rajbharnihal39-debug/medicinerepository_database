package TableConnection;

import AllConstructor.Purchaseorders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Purchaseordersconnectitivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================
    // INSERT
    // =========================

    public void insertpurchaseorder(Purchaseorders purchaseorder) {

        String sql = """
                INSERT INTO purchase_orders
                (po_number, supplier_id, order_date, expected_date,
                 status, subtotal, tax, discount, total_amount, notes)
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
                    purchaseorder.getPoNumber()
            );

            preparedStatement.setInt(
                    2,
                    purchaseorder.getSupplierId()
            );

            preparedStatement.setString(
                    3,
                    purchaseorder.getOrderDate()
            );

            preparedStatement.setString(
                    4,
                    purchaseorder.getExpectedDate()
            );

            preparedStatement.setString(
                    5,
                    purchaseorder.getStatus()
            );

            preparedStatement.setDouble(
                    6,
                    purchaseorder.getSubtotal()
            );

            preparedStatement.setDouble(
                    7,
                    purchaseorder.getTax()
            );

            preparedStatement.setDouble(
                    8,
                    purchaseorder.getDiscount()
            );

            preparedStatement.setDouble(
                    9,
                    purchaseorder.getTotalAmount()
            );

            preparedStatement.setString(
                    10,
                    purchaseorder.getNotes()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Purchase order creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or purchase order insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // UPDATE
    // =========================

    public void updatepurchaseorder(Purchaseorders purchaseorder) {

        String sql = """
                UPDATE purchase_orders
                SET po_number = ?,
                    supplier_id = ?,
                    order_date = ?,
                    expected_date = ?,
                    status = ?,
                    subtotal = ?,
                    tax = ?,
                    discount = ?,
                    total_amount = ?,
                    notes = ?
                WHERE purchase_order_id = ?
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
                    purchaseorder.getPoNumber()
            );

            preparedStatement.setInt(
                    2,
                    purchaseorder.getSupplierId()
            );

            preparedStatement.setString(
                    3,
                    purchaseorder.getOrderDate()
            );

            preparedStatement.setString(
                    4,
                    purchaseorder.getExpectedDate()
            );

            preparedStatement.setString(
                    5,
                    purchaseorder.getStatus()
            );

            preparedStatement.setDouble(
                    6,
                    purchaseorder.getSubtotal()
            );

            preparedStatement.setDouble(
                    7,
                    purchaseorder.getTax()
            );

            preparedStatement.setDouble(
                    8,
                    purchaseorder.getDiscount()
            );

            preparedStatement.setDouble(
                    9,
                    purchaseorder.getTotalAmount()
            );

            preparedStatement.setString(
                    10,
                    purchaseorder.getNotes()
            );

            preparedStatement.setInt(
                    11,
                    purchaseorder.getPurchaseOrderId()
            );


            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Purchase order update successful"
                );

            } else {

                System.out.println(
                        "No purchase order found with purchase_order_id: "
                                + purchaseorder.getPurchaseOrderId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database purchase order update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // DELETE
    // =========================

    public void deletepurchaseorder(int purchaseOrderId) {

        String sql = """
                DELETE FROM purchase_orders
                WHERE purchase_order_id = ?
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
                    purchaseOrderId
            );


            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Purchase order delete successful"
                );

            } else {

                System.out.println(
                        "No purchase order found with purchase_order_id: "
                                + purchaseOrderId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database purchase order delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // GET ALL PURCHASE ORDERS
    // =========================

    public void getallpurchaseorders() {

        String sql = """
                SELECT purchase_order_id,
                       po_number,
                       supplier_id,
                       order_date,
                       expected_date,
                       status,
                       subtotal,
                       tax,
                       discount,
                       total_amount,
                       notes
                FROM purchase_orders
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

                Purchaseorders purchaseorder =
                        new Purchaseorders();

                purchaseorder.setPurchaseOrderId(
                        resultSet.getInt(
                                "purchase_order_id"
                        )
                );

                purchaseorder.setPoNumber(
                        resultSet.getString(
                                "po_number"
                        )
                );

                purchaseorder.setSupplierId(
                        resultSet.getInt(
                                "supplier_id"
                        )
                );

                purchaseorder.setOrderDate(
                        resultSet.getString(
                                "order_date"
                        )
                );

                purchaseorder.setExpectedDate(
                        resultSet.getString(
                                "expected_date"
                        )
                );

                purchaseorder.setStatus(
                        resultSet.getString(
                                "status"
                        )
                );

                purchaseorder.setSubtotal(
                        resultSet.getDouble(
                                "subtotal"
                        )
                );

                purchaseorder.setTax(
                        resultSet.getDouble(
                                "tax"
                        )
                );

                purchaseorder.setDiscount(
                        resultSet.getDouble(
                                "discount"
                        )
                );

                purchaseorder.setTotalAmount(
                        resultSet.getDouble(
                                "total_amount"
                        )
                );

                purchaseorder.setNotes(
                        resultSet.getString(
                                "notes"
                        )
                );


                System.out.println(purchaseorder);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all purchase orders failed."
            );

            e.printStackTrace();
        }
    }
}
