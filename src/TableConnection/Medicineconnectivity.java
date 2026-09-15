package TableConnection;

import AllConstructor.Medicine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicineconnectivity {

    String url = "jdbc:mysql://localhost:3306/medicalsystem";
    String username = "root";
    String password = "nihal@raj#2026!";


    // =========================
    // INSERT
    // =========================

    public void createMedicine(Medicine medicine) {

        String sql = """
                INSERT INTO medicine
                (
                    medicine_code,
                    name,
                    generic_name,
                    category_id,
                    dosage_form,
                    strength,
                    unit,
                    record_level,
                    description,
                    status
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
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
                    medicine.getMedicineCode()
            );

            preparedStatement.setString(
                    2,
                    medicine.getName()
            );

            preparedStatement.setString(
                    3,
                    medicine.getGenericName()
            );

            preparedStatement.setInt(
                    4,
                    medicine.getCategoryId()
            );

            preparedStatement.setString(
                    5,
                    medicine.getDosageForm()
            );

            preparedStatement.setString(
                    6,
                    medicine.getStrength()
            );

            preparedStatement.setString(
                    7,
                    medicine.getUnit()
            );

            preparedStatement.setInt(
                    8,
                    medicine.getRecordLevel()
            );

            preparedStatement.setString(
                    9,
                    medicine.getDescription()
            );

            preparedStatement.setString(
                    10,
                    medicine.getStatus()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Medicine create operation successful"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Medicine insert failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // UPDATE
    // =========================

    public void updateMedicine(Medicine medicine) {

        String sql = """
                UPDATE medicine
                SET
                    medicine_code = ?,
                    name = ?,
                    generic_name = ?,
                    category_id = ?,
                    dosage_form = ?,
                    strength = ?,
                    unit = ?,
                    record_level = ?,
                    description = ?,
                    status = ?
                WHERE medicine_id = ?
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
                    medicine.getMedicineCode()
            );

            preparedStatement.setString(
                    2,
                    medicine.getName()
            );

            preparedStatement.setString(
                    3,
                    medicine.getGenericName()
            );

            preparedStatement.setInt(
                    4,
                    medicine.getCategoryId()
            );

            preparedStatement.setString(
                    5,
                    medicine.getDosageForm()
            );

            preparedStatement.setString(
                    6,
                    medicine.getStrength()
            );

            preparedStatement.setString(
                    7,
                    medicine.getUnit()
            );

            preparedStatement.setInt(
                    8,
                    medicine.getRecordLevel()
            );

            preparedStatement.setString(
                    9,
                    medicine.getDescription()
            );

            preparedStatement.setString(
                    10,
                    medicine.getStatus()
            );

            preparedStatement.setInt(
                    11,
                    medicine.getId()
            );

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Medicine update operation successful"
                );

            } else {

                System.out.println(
                        "No medicine found with ID: "
                                + medicine.getId()
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Medicine update failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // DELETE
    // =========================

    public void deleteMedicine(int id) {

        String sql = """
                DELETE FROM medicine
                WHERE medicine_id = ?
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

            preparedStatement.setInt(1, id);

            int rowaffected =
                    preparedStatement.executeUpdate();

            if (rowaffected == 1) {

                System.out.println(
                        "Medicine delete operation successful"
                );

            } else {

                System.out.println(
                        "No medicine found with ID: " + id
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Medicine delete failed"
            );

            e.printStackTrace();
        }
    }


    // =========================
    // GET ALL
    // =========================

    public void getAllMedicine() {

        String sql = """
                SELECT
                    medicine_id,
                    medicine_code,
                    name,
                    generic_name,
                    category_id,
                    dosage_form,
                    strength,
                    unit,
                    record_level,
                    description,
                    status
                FROM medicine
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

                Medicine medicine =
                        new Medicine(
                                resultSet.getInt(
                                        "medicine_id"
                                ),

                                resultSet.getString(
                                        "medicine_code"
                                ),

                                resultSet.getString(
                                        "name"
                                ),

                                resultSet.getString(
                                        "generic_name"
                                ),

                                resultSet.getInt(
                                        "category_id"
                                ),

                                resultSet.getString(
                                        "dosage_form"
                                ),

                                resultSet.getString(
                                        "strength"
                                ),

                                resultSet.getString(
                                        "unit"
                                ),

                                resultSet.getInt(
                                        "record_level"
                                ),

                                resultSet.getString(
                                        "description"
                                ),

                                resultSet.getString(
                                        "status"
                                )
                        );

                System.out.println(medicine);

                System.out.println(
                        "-------------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Get all medicines failed"
            );

            e.printStackTrace();
        }
    }
}
