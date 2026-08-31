package TableConnection;

import AllConstructor.Medicinebatches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class Medicinebatchesconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================================================
    // INSERT MEDICINE BATCH
    // =========================================================

    public void insertmedicinebatches(Medicinebatches batch) {

        String sql = """
                INSERT INTO medicine_batches
                (
                    medicine_id,
                    supplier_id,
                    batch_number,
                    manufacture_date,
                    expiry_date,
                    purchase_price,
                    selling_price,
                    quantity_received,
                    quantity_available
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
                    batch.getMedicineId()
            );

            preparedStatement.setInt(
                    2,
                    batch.getSupplierId()
            );

            preparedStatement.setString(
                    3,
                    batch.getBatchNumber()
            );

            preparedStatement.setDate(
                    4,
                    Date.valueOf(batch.getManufactureDate())
            );

            preparedStatement.setDate(
                    5,
                    Date.valueOf(batch.getExpiryDate())
            );

            preparedStatement.setDouble(
                    6,
                    batch.getPurchasePrice()
            );

            preparedStatement.setDouble(
                    7,
                    batch.getSellingPrice()
            );

            preparedStatement.setInt(
                    8,
                    batch.getQuantityReceived()
            );

            preparedStatement.setInt(
                    9,
                    batch.getQuantityAvailable()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Medicine batch creation successful"
                );

            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection or medicine batch insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // UPDATE MEDICINE BATCH
    // =========================================================

    public void updateMedicinebatch(Medicinebatches batch) {

        String sql = """
                UPDATE medicine_batches
                SET
                    medicine_id = ?,
                    supplier_id = ?,
                    batch_number = ?,
                    manufacture_date = ?,
                    expiry_date = ?,
                    purchase_price = ?,
                    selling_price = ?,
                    quantity_received = ?,
                    quantity_available = ?
                WHERE batch_id = ?
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
                    batch.getMedicineId()
            );

            preparedStatement.setInt(
                    2,
                    batch.getSupplierId()
            );

            preparedStatement.setString(
                    3,
                    batch.getBatchNumber()
            );

            preparedStatement.setDate(
                    4,
                    Date.valueOf(batch.getManufactureDate())
            );

            preparedStatement.setDate(
                    5,
                    Date.valueOf(batch.getExpiryDate())
            );

            preparedStatement.setDouble(
                    6,
                    batch.getPurchasePrice()
            );

            preparedStatement.setDouble(
                    7,
                    batch.getSellingPrice()
            );

            preparedStatement.setInt(
                    8,
                    batch.getQuantityReceived()
            );

            preparedStatement.setInt(
                    9,
                    batch.getQuantityAvailable()
            );

            preparedStatement.setInt(
                    10,
                    batch.getBatchId()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Medicine batch update successful"
                );

            } else {

                System.out.println(
                        "No medicine batch found with batch_id: "
                                + batch.getBatchId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database medicine batch update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE MEDICINE BATCH
    // =========================================================

    public void deleteMedicinebatch(int batchId) {

        String sql = """
                DELETE FROM medicine_batches
                WHERE batch_id = ?
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
                    batchId
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Medicine batch delete successful"
                );

            } else {

                System.out.println(
                        "No medicine batch found with batch_id: "
                                + batchId
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database medicine batch delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================================================
    // GET ALL MEDICINE BATCHES
    // =========================================================

    public void getAllMedicinebatches() {

        String sql = """
                SELECT
                    batch_id,
                    medicine_id,
                    supplier_id,
                    batch_number,
                    manufacture_date,
                    expiry_date,
                    purchase_price,
                    selling_price,
                    quantity_received,
                    quantity_available
                FROM medicine_batches
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

                int batchId =
                        resultSet.getInt(
                                "batch_id"
                        );

                int medicineId =
                        resultSet.getInt(
                                "medicine_id"
                        );

                int supplierId =
                        resultSet.getInt(
                                "supplier_id"
                        );

                String batchNumber =
                        resultSet.getString(
                                "batch_number"
                        );

                LocalDate manufactureDate = null;

                if (resultSet.getDate(
                        "manufacture_date"
                ) != null) {

                    manufactureDate =
                            resultSet.getDate(
                                    "manufacture_date"
                            ).toLocalDate();
                }

                LocalDate expiryDate = null;

                if (resultSet.getDate(
                        "expiry_date"
                ) != null) {

                    expiryDate =
                            resultSet.getDate(
                                    "expiry_date"
                            ).toLocalDate();
                }

                double purchasePrice =
                        resultSet.getDouble(
                                "purchase_price"
                        );

                double sellingPrice =
                        resultSet.getDouble(
                                "selling_price"
                        );

                int quantityReceived =
                        resultSet.getInt(
                                "quantity_received"
                        );

                int quantityAvailable =
                        resultSet.getInt(
                                "quantity_available"
                        );


                Medicinebatches batch =
                        new Medicinebatches(
                                batchId,
                                medicineId,
                                supplierId,
                                batchNumber,
                                manufactureDate,
                                expiryDate,
                                purchasePrice,
                                sellingPrice,
                                quantityReceived,
                                quantityAvailable
                        );


                System.out.println(batch);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all medicine batches failed."
            );

            e.printStackTrace();
        }
    }
}
