package TableConnection;

import AllConstructor.Suppliers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Suppliersconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT SUPPLIER
    // =========================================================

    public void insertsupplier(Suppliers supplier) {

        String sql = """
                INSERT INTO suppliers
                (
                    supplier_code,
                    name,
                    contact_person,
                    phone,
                    email,
                    address,
                    gst_number,
                    status
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
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
                    supplier.getSupplierCode()
            );

            preparedStatement.setString(
                    2,
                    supplier.getSupplierName()
            );

            preparedStatement.setString(
                    3,
                    supplier.getContactPerson()
            );

            preparedStatement.setString(
                    4,
                    supplier.getPhone()
            );

            preparedStatement.setString(
                    5,
                    supplier.getEmail()
            );

            preparedStatement.setString(
                    6,
                    supplier.getAddress()
            );

            preparedStatement.setString(
                    7,
                    supplier.getGstNumber()
            );

            preparedStatement.setString(
                    8,
                    supplier.getStatus()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Supplier creation successful"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Supplier insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE SUPPLIER
    // =========================================================

    public void updatesupplier(Suppliers supplier) {

        String sql = """
                UPDATE suppliers
                SET
                    supplier_code = ?,
                    name = ?,
                    contact_person = ?,
                    phone = ?,
                    email = ?,
                    address = ?,
                    gst_number = ?,
                    status = ?
                WHERE supplier_id = ?
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
                    supplier.getSupplierCode()
            );

            preparedStatement.setString(
                    2,
                    supplier.getSupplierName()
            );

            preparedStatement.setString(
                    3,
                    supplier.getContactPerson()
            );

            preparedStatement.setString(
                    4,
                    supplier.getPhone()
            );

            preparedStatement.setString(
                    5,
                    supplier.getEmail()
            );

            preparedStatement.setString(
                    6,
                    supplier.getAddress()
            );

            preparedStatement.setString(
                    7,
                    supplier.getGstNumber()
            );

            preparedStatement.setString(
                    8,
                    supplier.getStatus()
            );

            preparedStatement.setInt(
                    9,
                    supplier.getSupplierId()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Supplier update successful"
                );

            } else {

                System.out.println(
                        "No supplier found with supplier_id: "
                                + supplier.getSupplierId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Supplier update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE SUPPLIER
    // =========================================================

    public void deletesupplier(int supplierId) {

        String sql = """
                DELETE FROM suppliers
                WHERE supplier_id = ?
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
                    supplierId
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Supplier delete successful"
                );

            } else {

                System.out.println(
                        "No supplier found with supplier_id: "
                                + supplierId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Supplier delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL SUPPLIERS
    // =========================================================

    public void getallsuppliers() {

        String sql = """
                SELECT
                    supplier_id,
                    supplier_code,
                    name,
                    contact_person,
                    phone,
                    email,
                    address,
                    gst_number,
                    status
                FROM suppliers
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

                int supplierId =
                        resultSet.getInt(
                                "supplier_id"
                        );

                String supplierCode =
                        resultSet.getString(
                                "supplier_code"
                        );

                String supplierName =
                        resultSet.getString(
                                "name"
                        );

                String contactPerson =
                        resultSet.getString(
                                "contact_person"
                        );

                String phone =
                        resultSet.getString(
                                "phone"
                        );

                String email =
                        resultSet.getString(
                                "email"
                        );

                String address =
                        resultSet.getString(
                                "address"
                        );

                String gstNumber =
                        resultSet.getString(
                                "gst_number"
                        );

                String status =
                        resultSet.getString(
                                "status"
                        );


                Suppliers supplier =
                        new Suppliers(
                                supplierId,
                                supplierCode,
                                supplierName,
                                contactPerson,
                                phone,
                                email,
                                address,
                                gstNumber,
                                status
                        );


                System.out.println(supplier);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all suppliers failed"
            );

            e.printStackTrace();
        }
    }
}
