package Alltablesconnection;

import AllConstructor.medicalsystem;
import AllConstructor.Users;
import AllConstructor.Medicinecategories;
import AllConstructor.Purchaseorders;
import AllConstructor.Medicine;
import AllConstructor.Suppliers;
import AllConstructor.Medicinebatches;
import AllConstructor.Purchaseorderitems;
import AllConstructor.Sales;
import AllConstructor.Saleitems;
import AllConstructor.Stocktransactions;
import AllConstructor.Expiryalerts;

import TableConnection.Medicalsystemrepository;
import TableConnection.Usersconnectivity;
import TableConnection.Medicinecategoryiesconnectivity;
import TableConnection.Medicineconnectivity;
import TableConnection.Suppliersconnectivity;
import TableConnection.Medicinebatchesconnectivity;
import TableConnection.Purchaseordersconnectitivity;
import TableConnection.Purchaseorderitemsconnectivity;
import TableConnection.Salesconnectivity;
import TableConnection.Saleitemsconnectivity;
import TableConnection.Stocktrannsactionsconnectivity;
import TableConnection.Expiryalertsconnectivity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Tablesconnectivity {

    public static void main(String[] args) {

        // =========================================================
        // CONNECTIVITY OBJECTS
        // =========================================================

        Medicalsystemrepository medicalSystemRepository = new Medicalsystemrepository();

        Usersconnectivity usersconnectivity =new Usersconnectivity();

        Medicinecategoryiesconnectivity medicinecategoryiesconnectivity =new Medicinecategoryiesconnectivity();

        Medicineconnectivity medicineconnectivity = new Medicineconnectivity();

        Suppliersconnectivity suppliersconnectivity = new Suppliersconnectivity();

        Medicinebatchesconnectivity medicinebatchesconnectivity = new Medicinebatchesconnectivity();

        Purchaseordersconnectitivity purchaseordersconnectitivity = new Purchaseordersconnectitivity();

        Purchaseorderitemsconnectivity purchaseorderitemsconnectivity =
                new Purchaseorderitemsconnectivity();

        Salesconnectivity salesconnectivity =
                new Salesconnectivity();

        Saleitemsconnectivity saleitemsconnectivity =
                new Saleitemsconnectivity();

        Stocktrannsactionsconnectivity stocktrannsactionsconnectivity =
                new Stocktrannsactionsconnectivity();

        Expiryalertsconnectivity expiryalertsconnectivity =
                new Expiryalertsconnectivity();

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        // =========================================================
        // MAIN MENU
        // =========================================================

        while (true) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("          MEDICAL SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Roles");
            System.out.println("2. Users");
            System.out.println("3. Medicine Categories");
            System.out.println("4. Medicine");
            System.out.println("5. Suppliers");
            System.out.println("6. Medicine Batches");
            System.out.println("7. Purchase Orders");
            System.out.println("8. Purchase Order Items");
            System.out.println("9. Sales");
            System.out.println("10. Sale Items");
            System.out.println("11. Stock Transactions");
            System.out.println("12. Expiry Alerts");
            System.out.println("13. Exit");

            System.out.print("Enter your option: ");

            int option = sc.nextInt();

            switch (option) {

                // =================================================
                // 1. ROLES
                // =================================================

                case 1:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("             ROLE MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print("Enter your option: ");

                        int roleOption = sc.nextInt();

                        switch (roleOption) {

                            case 1:

                                medicalSystemRepository.roleuser(
                                        new medicalsystem(
                                                10,
                                                "Nihal",
                                                "Take care of patient"
                                        )
                                );

                                break;

                            case 2:

                                medicalSystemRepository.updateroleuser(
                                        new medicalsystem(
                                                2,
                                                "Specialist Surgeon",
                                                "Specialist in cardiologist"
                                        )
                                );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter role ID to delete: "
                                );

                                int roleId = sc.nextInt();

                                medicalSystemRepository.deleterole(
                                        roleId
                                );

                                break;

                            case 4:

                                medicalSystemRepository.getallroles();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (roleOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 2. USERS
                // =================================================

                case 2:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("             USER MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print("Enter your option: ");

                        int userOption = sc.nextInt();

                        switch (userOption) {

                            case 1:

                                usersconnectivity.insertuser(
                                        new Users(
                                                5,
                                                2,
                                                "Nihal",
                                                "nihal@medicine.com",
                                                "nihal123",
                                                "Active",
                                                null
                                        )
                                );

                                break;

                            case 2:

                                usersconnectivity.updateuser(
                                        new Users(
                                                5,
                                                2,
                                                "Nihal Raj",
                                                "nihalraj@medicine.com",
                                                "nihal456",
                                                "Active",
                                                null
                                        )
                                );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter user ID to delete: "
                                );

                                int userId = sc.nextInt();

                                usersconnectivity.deleteuser(
                                        userId
                                );

                                break;

                            case 4:

                                usersconnectivity.getallusers();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (userOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 3. MEDICINE CATEGORIES
                // =================================================

                case 3:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("       MEDICINE CATEGORY MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print("Enter your option: ");

                        int categoryOption = sc.nextInt();

                        switch (categoryOption) {

                            case 1:

                                Medicinecategories medicinecategories =
                                        new Medicinecategories();

                                System.out.print(
                                        "Enter category ID: "
                                );

                                int categoryId = sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter category name: "
                                );

                                String categoryName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter description: "
                                );

                                String description =
                                        sc.nextLine();

                                medicinecategories.setId(
                                        categoryId
                                );

                                medicinecategories.setCategoryName(
                                        categoryName
                                );

                                medicinecategories.setDescription(
                                        description
                                );

                                medicinecategoryiesconnectivity
                                        .insertmedicinecategories(
                                                medicinecategories
                                        );

                                break;

                            case 2:

                                Medicinecategories updatecategory =
                                        new Medicinecategories();

                                System.out.print(
                                        "Enter category ID to update: "
                                );

                                int updateCategoryId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter new category name: "
                                );

                                String updateCategoryName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter new description: "
                                );

                                String updateDescription =
                                        sc.nextLine();

                                updatecategory.setId(
                                        updateCategoryId
                                );

                                updatecategory.setCategoryName(
                                        updateCategoryName
                                );

                                updatecategory.setDescription(
                                        updateDescription
                                );

                                medicinecategoryiesconnectivity
                                        .updatemedicinecategories(
                                                updatecategory
                                        );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter category ID to delete: "
                                );

                                int deleteCategoryId =
                                        sc.nextInt();

                                medicinecategoryiesconnectivity
                                        .deletemedicinecategories(
                                                deleteCategoryId
                                        );

                                break;

                            case 4:

                                medicinecategoryiesconnectivity
                                        .getallmedicinecategories();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (categoryOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 4. MEDICINE
                // =================================================

                case 4:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("           MEDICINE MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print("Enter your option: ");

                        int medicineOption = sc.nextInt();

                        switch (medicineOption) {

                            case 1:

                                Medicine medicine =
                                        new Medicine();

                                System.out.print(
                                        "Enter medicine code: "
                                );

                                String medicineCode =
                                        sc.next();

                                sc.nextLine();

                                System.out.print(
                                        "Enter medicine name: "
                                );

                                String medicineName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter generic name: "
                                );

                                String genericName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter category ID: "
                                );

                                int medicineCategoryId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter dosage form: "
                                );

                                String dosageForm =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter strength: "
                                );

                                String strength =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter unit: "
                                );

                                String unit =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter record level: "
                                );

                                int recordLevel =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter description: "
                                );

                                String medicineDescription =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String status =
                                        sc.nextLine();

                                medicine.setMedicineCode(
                                        medicineCode
                                );

                                medicine.setName(
                                        medicineName
                                );

                                medicine.setGenericName(
                                        genericName
                                );

                                medicine.setCategoryId(
                                        medicineCategoryId
                                );

                                medicine.setDosageForm(
                                        dosageForm
                                );

                                medicine.setStrength(
                                        strength
                                );

                                medicine.setUnit(
                                        unit
                                );

                                medicine.setRecordLevel(
                                        recordLevel
                                );

                                medicine.setDescription(
                                        medicineDescription
                                );

                                medicine.setStatus(
                                        status
                                );

                                medicineconnectivity.createMedicine(
                                        medicine
                                );

                                break;

                            case 2:

                                Medicine updateMedicine =
                                        new Medicine();

                                System.out.print(
                                        "Enter medicine ID to update: "
                                );

                                int updateMedicineId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter medicine code: "
                                );

                                String updateMedicineCode =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter medicine name: "
                                );

                                String updateMedicineName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter generic name: "
                                );

                                String updateGenericName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter category ID: "
                                );

                                int updateMedicineCategoryId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter dosage form: "
                                );

                                String updateDosageForm =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter strength: "
                                );

                                String updateStrength =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter unit: "
                                );

                                String updateUnit =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter record level: "
                                );

                                int updateRecordLevel =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter description: "
                                );

                                String updateMedicineDescription =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String updateStatus =
                                        sc.nextLine();

                                updateMedicine.setId(
                                        updateMedicineId
                                );

                                updateMedicine.setMedicineCode(
                                        updateMedicineCode
                                );

                                updateMedicine.setName(
                                        updateMedicineName
                                );

                                updateMedicine.setGenericName(
                                        updateGenericName
                                );

                                updateMedicine.setCategoryId(
                                        updateMedicineCategoryId
                                );

                                updateMedicine.setDosageForm(
                                        updateDosageForm
                                );

                                updateMedicine.setStrength(
                                        updateStrength
                                );

                                updateMedicine.setUnit(
                                        updateUnit
                                );

                                updateMedicine.setRecordLevel(
                                        updateRecordLevel
                                );

                                updateMedicine.setDescription(
                                        updateMedicineDescription
                                );

                                updateMedicine.setStatus(
                                        updateStatus
                                );

                                medicineconnectivity.updateMedicine(
                                        updateMedicine
                                );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter medicine ID to delete: "
                                );

                                int deleteMedicineId =
                                        sc.nextInt();

                                medicineconnectivity.deleteMedicine(
                                        deleteMedicineId
                                );

                                break;

                            case 4:

                                medicineconnectivity.getAllMedicine();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (medicineOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 5. SUPPLIERS
                // =================================================

                case 5:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("           SUPPLIER MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int supplierOption = sc.nextInt();

                        switch (supplierOption) {

                            case 1:

                                Suppliers supplier =
                                        new Suppliers();

                                System.out.print(
                                        "Enter supplier code: "
                                );

                                String supplierCode =
                                        sc.next();

                                sc.nextLine();

                                System.out.print(
                                        "Enter supplier name: "
                                );

                                String supplierName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter contact person: "
                                );

                                String contactPerson =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter phone: "
                                );

                                String phone =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter email: "
                                );

                                String email =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter address: "
                                );

                                String address =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter GST number: "
                                );

                                String gstNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String supplierStatus =
                                        sc.nextLine();

                                supplier.setSupplierCode(
                                        supplierCode
                                );

                                supplier.setSupplierName(
                                        supplierName
                                );

                                supplier.setContactPerson(
                                        contactPerson
                                );

                                supplier.setPhone(
                                        phone
                                );

                                supplier.setEmail(
                                        email
                                );

                                supplier.setAddress(
                                        address
                                );

                                supplier.setGstNumber(
                                        gstNumber
                                );

                                supplier.setStatus(
                                        supplierStatus
                                );

                                suppliersconnectivity.insertsupplier(
                                        supplier
                                );

                                break;

                            case 2:

                                Suppliers updateSupplier =
                                        new Suppliers();

                                System.out.print(
                                        "Enter supplier ID to update: "
                                );

                                int updateSupplierId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter supplier code: "
                                );

                                String updateSupplierCode =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter supplier name: "
                                );

                                String updateSupplierName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter contact person: "
                                );

                                String updateSupplierContactPerson =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter phone: "
                                );

                                String updateSupplierPhone =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter email: "
                                );

                                String updateSupplierEmail =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter address: "
                                );

                                String updateSupplierAddress =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter GST number: "
                                );

                                String updateSupplierGstNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String updateSupplierStatus =
                                        sc.nextLine();

                                updateSupplier.setSupplierId(
                                        updateSupplierId
                                );

                                updateSupplier.setSupplierCode(
                                        updateSupplierCode
                                );

                                updateSupplier.setSupplierName(
                                        updateSupplierName
                                );

                                updateSupplier.setContactPerson(
                                        updateSupplierContactPerson
                                );

                                updateSupplier.setPhone(
                                        updateSupplierPhone
                                );

                                updateSupplier.setEmail(
                                        updateSupplierEmail
                                );

                                updateSupplier.setAddress(
                                        updateSupplierAddress
                                );

                                updateSupplier.setGstNumber(
                                        updateSupplierGstNumber
                                );

                                updateSupplier.setStatus(
                                        updateSupplierStatus
                                );

                                suppliersconnectivity.updatesupplier(
                                        updateSupplier
                                );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter supplier ID to delete: "
                                );

                                int deleteSupplierId =
                                        sc.nextInt();

                                suppliersconnectivity.deletesupplier(
                                        deleteSupplierId
                                );

                                break;

                            case 4:

                                suppliersconnectivity.getallsuppliers();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (supplierOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 6. MEDICINE BATCHES
                // =================================================

                case 6:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("       MEDICINE BATCH MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int batchOption = sc.nextInt();

                        switch (batchOption) {

                            case 1:

                                Medicinebatches medicinebatches =
                                        new Medicinebatches();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int batchId = sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int medicineId = sc.nextInt();

                                System.out.print(
                                        "Enter supplier ID: "
                                );

                                int supplierId = sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter batch number: "
                                );

                                String batchNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter manufacture date (YYYY-MM-DD): "
                                );

                                String manufactureDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter expiry date (YYYY-MM-DD): "
                                );

                                String expiryDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter purchase price: "
                                );

                                double purchasePrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter selling price: "
                                );

                                double sellingPrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int quantity =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter available quantity: "
                                );

                                int availableQuantity =
                                        sc.nextInt();

                                medicinebatches.setBatchId(
                                        batchId
                                );

                                medicinebatches.setMedicineId(
                                        medicineId
                                );

                                medicinebatches.setSupplierId(
                                        supplierId
                                );

                                medicinebatches.setBatchNumber(
                                        batchNumber
                                );

                                medicinebatches.setManufactureDate(
                                        LocalDate.parse(
                                                manufactureDateInput
                                        )
                                );

                                medicinebatches.setExpiryDate(
                                        LocalDate.parse(
                                                expiryDateInput
                                        )
                                );

                                medicinebatches.setPurchasePrice(
                                        purchasePrice
                                );

                                medicinebatches.setSellingPrice(
                                        sellingPrice
                                );

                                medicinebatches.setQuantityReceived(
                                        quantity
                                );

                                medicinebatches.setQuantityAvailable(
                                        availableQuantity
                                );

                                medicinebatchesconnectivity
                                        .insertmedicinebatches(
                                                medicinebatches
                                        );

                                break;

                            case 2:

                                Medicinebatches updateBatch =
                                        new Medicinebatches();

                                System.out.print(
                                        "Enter batch ID to update: "
                                );

                                int updateBatchId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int updateMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter supplier ID: "
                                );

                                int updateSupplierId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter batch number: "
                                );

                                String updateBatchNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter manufacture date (YYYY-MM-DD): "
                                );

                                String updateManufactureDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter expiry date (YYYY-MM-DD): "
                                );

                                String updateExpiryDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter purchase price: "
                                );

                                double updatePurchasePrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter selling price: "
                                );

                                double updateSellingPrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int updateQuantity =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter available quantity: "
                                );

                                int updateAvailableQuantity =
                                        sc.nextInt();

                                updateBatch.setBatchId(
                                        updateBatchId
                                );

                                updateBatch.setMedicineId(
                                        updateMedicineId
                                );

                                updateBatch.setSupplierId(
                                        updateSupplierId
                                );

                                updateBatch.setBatchNumber(
                                        updateBatchNumber
                                );

                                updateBatch.setManufactureDate(
                                        LocalDate.parse(
                                                updateManufactureDateInput
                                        )
                                );

                                updateBatch.setExpiryDate(
                                        LocalDate.parse(
                                                updateExpiryDateInput
                                        )
                                );

                                updateBatch.setPurchasePrice(
                                        updatePurchasePrice
                                );

                                updateBatch.setSellingPrice(
                                        updateSellingPrice
                                );

                                updateBatch.setQuantityReceived(
                                        updateQuantity
                                );

                                updateBatch.setQuantityAvailable(
                                        updateAvailableQuantity
                                );

                                medicinebatchesconnectivity
                                        .updateMedicinebatch(
                                                updateBatch
                                        );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter batch ID to delete: "
                                );

                                int deleteBatchId =
                                        sc.nextInt();

                                medicinebatchesconnectivity
                                        .deleteMedicinebatch(
                                                deleteBatchId
                                        );

                                break;

                            case 4:

                                medicinebatchesconnectivity
                                        .getAllMedicinebatches();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (batchOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 7. PURCHASE ORDERS
                // =================================================

                case 7:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("         PURCHASE ORDER MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int purchaseOrderOption =
                                sc.nextInt();

                        switch (purchaseOrderOption) {

                            case 1:

                                Purchaseorders purchaseorder =
                                        new Purchaseorders();

                                System.out.print(
                                        "Enter PO number: "
                                );

                                String poNumber =
                                        sc.next();

                                System.out.print(
                                        "Enter supplier ID: "
                                );

                                int purchaseOrderSupplierId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter order date (YYYY-MM-DD): "
                                );

                                String orderDate =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter expected date (YYYY-MM-DD): "
                                );

                                String expectedDate =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String purchaseOrderStatus =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter subtotal: "
                                );

                                double subtotal =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double tax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double discount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double totalAmount =
                                        sc.nextDouble();

                                sc.nextLine();

                                System.out.print(
                                        "Enter notes: "
                                );

                                String notes =
                                        sc.nextLine();

                                purchaseorder.setPoNumber(
                                        poNumber
                                );

                                purchaseorder.setSupplierId(
                                        purchaseOrderSupplierId
                                );

                                purchaseorder.setOrderDate(
                                        orderDate
                                );

                                purchaseorder.setExpectedDate(
                                        expectedDate
                                );

                                purchaseorder.setStatus(
                                        purchaseOrderStatus
                                );

                                purchaseorder.setSubtotal(
                                        subtotal
                                );

                                purchaseorder.setTax(
                                        tax
                                );

                                purchaseorder.setDiscount(
                                        discount
                                );

                                purchaseorder.setTotalAmount(
                                        totalAmount
                                );

                                purchaseorder.setNotes(
                                        notes
                                );

                                purchaseordersconnectitivity
                                        .insertpurchaseorder(
                                                purchaseorder
                                        );

                                break;

                            case 2:

                                Purchaseorders updatePurchaseOrder =
                                        new Purchaseorders();

                                System.out.print(
                                        "Enter purchase order ID to update: "
                                );

                                int updatePurchaseOrderId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter PO number: "
                                );

                                String updatePoNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter supplier ID: "
                                );

                                int updatePurchaseOrderSupplierId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter order date (YYYY-MM-DD): "
                                );

                                String updateOrderDate =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter expected date (YYYY-MM-DD): "
                                );

                                String updateExpectedDate =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String updatePurchaseOrderStatus =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter subtotal: "
                                );

                                double updateSubtotal =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double updateTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double updateDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double updateTotalAmount =
                                        sc.nextDouble();

                                sc.nextLine();

                                System.out.print(
                                        "Enter notes: "
                                );

                                String updateNotes =
                                        sc.nextLine();

                                updatePurchaseOrder
                                        .setPurchaseOrderId(
                                                updatePurchaseOrderId
                                        );

                                updatePurchaseOrder.setPoNumber(
                                        updatePoNumber
                                );

                                updatePurchaseOrder.setSupplierId(
                                        updatePurchaseOrderSupplierId
                                );

                                updatePurchaseOrder.setOrderDate(
                                        updateOrderDate
                                );

                                updatePurchaseOrder.setExpectedDate(
                                        updateExpectedDate
                                );

                                updatePurchaseOrder.setStatus(
                                        updatePurchaseOrderStatus
                                );

                                updatePurchaseOrder.setSubtotal(
                                        updateSubtotal
                                );

                                updatePurchaseOrder.setTax(
                                        updateTax
                                );

                                updatePurchaseOrder.setDiscount(
                                        updateDiscount
                                );

                                updatePurchaseOrder.setTotalAmount(
                                        updateTotalAmount
                                );

                                updatePurchaseOrder.setNotes(
                                        updateNotes
                                );

                                purchaseordersconnectitivity
                                        .updatepurchaseorder(
                                                updatePurchaseOrder
                                        );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter purchase order ID to delete: "
                                );

                                int deletePurchaseOrderId =
                                        sc.nextInt();

                                purchaseordersconnectitivity
                                        .deletepurchaseorder(
                                                deletePurchaseOrderId
                                        );

                                break;

                            case 4:

                                purchaseordersconnectitivity
                                        .getallpurchaseorders();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (purchaseOrderOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 8. PURCHASE ORDER ITEMS
                // =================================================

                case 8:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("       PURCHASE ORDER ITEMS MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int purchaseOrderItemOption =
                                sc.nextInt();

                        switch (purchaseOrderItemOption) {

                            case 1:

                                Purchaseorderitems purchaseOrderItem =
                                        new Purchaseorderitems();

                                System.out.print(
                                        "Enter purchase order ID: "
                                );

                                int purchaseOrderId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int itemMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int itemQuantity =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter unit price: "
                                );

                                double unitPrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double itemTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double itemDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double itemTotalAmount =
                                        sc.nextDouble();

                                purchaseOrderItem.setPurchaseOrderId(
                                        purchaseOrderId
                                );

                                purchaseOrderItem.setMedicineId(
                                        itemMedicineId
                                );

                                purchaseOrderItem.setQuantityOrdered(
                                        itemQuantity
                                );

                                purchaseOrderItem.setUnitPrice(
                                        unitPrice
                                );

                                purchaseOrderItem.setTax(
                                        itemTax
                                );

                                purchaseOrderItem.setDiscount(
                                        itemDiscount
                                );

                                purchaseOrderItem.setTotalAmount(
                                        itemTotalAmount
                                );

                                purchaseorderitemsconnectivity
                                        .insertpurchaseorderitem(
                                                purchaseOrderItem
                                        );

                                break;

                            case 2:

                                Purchaseorderitems updatePurchaseOrderItem =
                                        new Purchaseorderitems();

                                System.out.print(
                                        "Enter purchase order item ID: "
                                );

                                int purchaseOrderItemId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter purchase order ID: "
                                );

                                int updatePurchaseOrderId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int updateMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int updateQuantity =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter unit price: "
                                );

                                double updateUnitPrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double updateTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double updateDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double updateTotalAmount =
                                        sc.nextDouble();

                                updatePurchaseOrderItem
                                        .setPurchaseOrderId(
                                                purchaseOrderItemId
                                        );

                                updatePurchaseOrderItem
                                        .setPurchaseOrderId(
                                                updatePurchaseOrderId
                                        );

                                updatePurchaseOrderItem
                                        .setMedicineId(
                                                updateMedicineId
                                        );

                                updatePurchaseOrderItem
                                        .setQuantityOrdered(
                                                updateQuantity
                                        );

                                updatePurchaseOrderItem
                                        .setUnitPrice(
                                                updateUnitPrice
                                        );

                                updatePurchaseOrderItem
                                        .setTax(
                                                updateTax
                                        );

                                updatePurchaseOrderItem
                                        .setDiscount(
                                                updateDiscount
                                        );

                                updatePurchaseOrderItem
                                        .setTotalAmount(
                                                updateTotalAmount
                                        );

                                purchaseorderitemsconnectivity
                                        .updatepurchaseorderitem(
                                                updatePurchaseOrderItem
                                        );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter purchase order item ID to delete: "
                                );

                                int deletePurchaseOrderItemId =
                                        sc.nextInt();

                                purchaseorderitemsconnectivity
                                        .deletepurchaseorderitem(
                                                deletePurchaseOrderItemId
                                        );

                                break;

                            case 4:

                                purchaseorderitemsconnectivity
                                        .getallpurchaseorderitems();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (purchaseOrderItemOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 9. SALES
                // =================================================

                case 9:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("              SALES MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int saleOption = sc.nextInt();

                        switch (saleOption) {

                            case 1:

                                Sales sale =
                                        new Sales();

                                sc.nextLine();

                                System.out.print(
                                        "Enter invoice number: "
                                );

                                String invoiceNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter customer name: "
                                );

                                String customerName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter sale date (YYYY-MM-DD HH:MM:SS): "
                                );

                                String saleDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter subtotal: "
                                );

                                double saleSubtotal =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double saleTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double saleDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double saleTotalAmount =
                                        sc.nextDouble();

                                sc.nextLine();

                                System.out.print(
                                        "Enter payment method: "
                                );

                                String paymentMethod =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String saleStatus =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter created by user ID: "
                                );

                                int createdBy =
                                        sc.nextInt();

                                sale.setInvoiceNumber(
                                        invoiceNumber
                                );

                                sale.setCustomerName(
                                        customerName
                                );

                                sale.setSaleDate(
                                        LocalDateTime.parse(
                                                saleDateInput,
                                                dateTimeFormatter
                                        )
                                );

                                sale.setSubtotal(
                                        saleSubtotal
                                );

                                sale.setTax(
                                        saleTax
                                );

                                sale.setDiscount(
                                        saleDiscount
                                );

                                sale.setTotalAmount(
                                        saleTotalAmount
                                );

                                sale.setPaymentMethod(
                                        paymentMethod
                                );

                                sale.setStatus(
                                        saleStatus
                                );

                                sale.setCreatedBy(
                                        createdBy
                                );

                                salesconnectivity.insertsale(
                                        sale
                                );

                                break;

                            case 2:

                                Sales updateSale =
                                        new Sales();

                                System.out.print(
                                        "Enter sale ID to update: "
                                );

                                int updateSaleId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter invoice number: "
                                );

                                String updateInvoiceNumber =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter customer name: "
                                );

                                String updateCustomerName =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter sale date (YYYY-MM-DD HH:MM:SS): "
                                );

                                String updateSaleDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter subtotal: "
                                );

                                double updateSaleSubtotal =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double updateSaleTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double updateSaleDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double updateSaleTotalAmount =
                                        sc.nextDouble();

                                sc.nextLine();

                                System.out.print(
                                        "Enter payment method: "
                                );

                                String updatePaymentMethod =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String updateSaleStatus =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter created by user ID: "
                                );

                                int updateCreatedBy =
                                        sc.nextInt();

                                updateSale.setSaleId(
                                        updateSaleId
                                );

                                updateSale.setInvoiceNumber(
                                        updateInvoiceNumber
                                );

                                updateSale.setCustomerName(
                                        updateCustomerName
                                );

                                updateSale.setSaleDate(
                                        LocalDateTime.parse(
                                                updateSaleDateInput,
                                                dateTimeFormatter
                                        )
                                );

                                updateSale.setSubtotal(
                                        updateSaleSubtotal
                                );

                                updateSale.setTax(
                                        updateSaleTax
                                );

                                updateSale.setDiscount(
                                        updateSaleDiscount
                                );

                                updateSale.setTotalAmount(
                                        updateSaleTotalAmount
                                );

                                updateSale.setPaymentMethod(
                                        updatePaymentMethod
                                );

                                updateSale.setStatus(
                                        updateSaleStatus
                                );

                                updateSale.setCreatedBy(
                                        updateCreatedBy
                                );

                                salesconnectivity.updatesale(
                                        updateSale
                                );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter sale ID to delete: "
                                );

                                int deleteSaleId =
                                        sc.nextInt();

                                salesconnectivity.deletesale(
                                        deleteSaleId
                                );

                                break;

                            case 4:

                                salesconnectivity.getallsales();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (saleOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 10. SALE ITEMS
                // =================================================

                case 10:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("           SALE ITEMS MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int saleItemOption = sc.nextInt();

                        switch (saleItemOption) {

                            case 1:

                                Saleitems saleItem =
                                        new Saleitems();

                                System.out.print(
                                        "Enter sale ID: "
                                );

                                int saleId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int saleMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int saleBatchId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int saleQuantity =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter unit price: "
                                );

                                double saleUnitPrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double saleItemDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double saleItemTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double saleItemTotalAmount =
                                        sc.nextDouble();

                                saleItem.setSaleId(
                                        saleId
                                );

                                saleItem.setMedicineId(
                                        saleMedicineId
                                );

                                saleItem.setBatchId(
                                        saleBatchId
                                );

                                saleItem.setQuantity(
                                        saleQuantity
                                );

                                saleItem.setUnitPrice(
                                        saleUnitPrice
                                );

                                saleItem.setDiscount(
                                        saleItemDiscount
                                );

                                saleItem.setTax(
                                        saleItemTax
                                );

                                saleItem.setTotalAmount(
                                        saleItemTotalAmount
                                );

                                saleitemsconnectivity.insertsaleitem(
                                        saleItem
                                );

                                break;

                            case 2:

                                Saleitems updateSaleItem =
                                        new Saleitems();

                                System.out.print(
                                        "Enter sale item ID to update: "
                                );

                                int updateSaleItemId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter sale ID: "
                                );

                                int updateSaleId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int updateSaleMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int updateSaleBatchId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int updateSaleQuantity =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter unit price: "
                                );

                                double updateSaleUnitPrice =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter discount: "
                                );

                                double updateSaleItemDiscount =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter tax: "
                                );

                                double updateSaleItemTax =
                                        sc.nextDouble();

                                System.out.print(
                                        "Enter total amount: "
                                );

                                double updateSaleItemTotalAmount =
                                        sc.nextDouble();

                                updateSaleItem.setSaleItemId(
                                        updateSaleItemId
                                );

                                updateSaleItem.setSaleId(
                                        updateSaleId
                                );

                                updateSaleItem.setMedicineId(
                                        updateSaleMedicineId
                                );

                                updateSaleItem.setBatchId(
                                        updateSaleBatchId
                                );

                                updateSaleItem.setQuantity(
                                        updateSaleQuantity
                                );

                                updateSaleItem.setUnitPrice(
                                        updateSaleUnitPrice
                                );

                                updateSaleItem.setDiscount(
                                        updateSaleItemDiscount
                                );

                                updateSaleItem.setTax(
                                        updateSaleItemTax
                                );

                                updateSaleItem.setTotalAmount(
                                        updateSaleItemTotalAmount
                                );

                                saleitemsconnectivity.updatesaleitem(
                                        updateSaleItem
                                );

                                break;

                            case 3:

                                System.out.print(
                                        "Enter sale item ID to delete: "
                                );

                                int deleteSaleItemId =
                                        sc.nextInt();

                                saleitemsconnectivity.deletesaleitem(
                                        deleteSaleItemId
                                );

                                break;

                            case 4:

                                saleitemsconnectivity.getallsaleitems();

                                break;

                            case 5:

                                break;

                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (saleItemOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 11. STOCK TRANSACTIONS
                // =================================================

                case 11:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("       STOCK TRANSACTIONS MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int stockTransactionOption =
                                sc.nextInt();

                        switch (stockTransactionOption) {

                            case 1:

                                Stocktransactions stockTransaction =
                                        new Stocktransactions();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int stockMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int stockBatchId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter transaction type: "
                                );

                                String transactionType =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int stockQuantity =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter reference type: "
                                );

                                String referenceType =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter reference ID: "
                                );

                                int referenceId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter transaction date (YYYY-MM-DD HH:MM:SS): "
                                );

                                String transactionDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter notes: "
                                );

                                String stockNotes =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter created by user ID: "
                                );

                                int stockCreatedBy =
                                        sc.nextInt();

                                stockTransaction.setMedicineId(
                                        stockMedicineId
                                );

                                stockTransaction.setBatchId(
                                        stockBatchId
                                );

                                stockTransaction.setTransactionType(
                                        transactionType
                                );

                                stockTransaction.setQuantity(
                                        stockQuantity
                                );

                                stockTransaction.setReferenceType(
                                        referenceType
                                );

                                stockTransaction.setReferenceId(
                                        referenceId
                                );

                                stockTransaction.setTransactionDate(
                                        LocalDateTime.parse(
                                                transactionDateInput,
                                                dateTimeFormatter
                                        )
                                );

                                stockTransaction.setNotes(
                                        stockNotes
                                );

                                stockTransaction.setCreatedBy(
                                        stockCreatedBy
                                );

                                stocktrannsactionsconnectivity
                                        .insertstocktransaction(
                                                stockTransaction
                                        );

                                break;


                            case 2:

                                Stocktransactions updateStockTransaction =
                                        new Stocktransactions();

                                System.out.print(
                                        "Enter transaction ID to update: "
                                );

                                int updateTransactionId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter medicine ID: "
                                );

                                int updateStockMedicineId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int updateStockBatchId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter transaction type: "
                                );

                                String updateTransactionType =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter quantity: "
                                );

                                int updateStockQuantity =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter reference type: "
                                );

                                String updateReferenceType =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter reference ID: "
                                );

                                int updateReferenceId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter transaction date (YYYY-MM-DD HH:MM:SS): "
                                );

                                String updateTransactionDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter notes: "
                                );

                                String updateStockNotes =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter created by user ID: "
                                );

                                int updateStockCreatedBy =
                                        sc.nextInt();

                                updateStockTransaction.setTransactionId(
                                        updateTransactionId
                                );

                                updateStockTransaction.setMedicineId(
                                        updateStockMedicineId
                                );

                                updateStockTransaction.setBatchId(
                                        updateStockBatchId
                                );

                                updateStockTransaction.setTransactionType(
                                        updateTransactionType
                                );

                                updateStockTransaction.setQuantity(
                                        updateStockQuantity
                                );

                                updateStockTransaction.setReferenceType(
                                        updateReferenceType
                                );

                                updateStockTransaction.setReferenceId(
                                        updateReferenceId
                                );

                                updateStockTransaction.setTransactionDate(
                                        LocalDateTime.parse(
                                                updateTransactionDateInput,
                                                dateTimeFormatter
                                        )
                                );

                                updateStockTransaction.setNotes(
                                        updateStockNotes
                                );

                                updateStockTransaction.setCreatedBy(
                                        updateStockCreatedBy
                                );

                                stocktrannsactionsconnectivity
                                        .updatestocktransaction(
                                                updateStockTransaction
                                        );

                                break;


                            case 3:

                                System.out.print(
                                        "Enter transaction ID to delete: "
                                );

                                int deleteTransactionId =
                                        sc.nextInt();

                                stocktrannsactionsconnectivity
                                        .deletestocktransaction(
                                                deleteTransactionId
                                        );

                                break;


                            case 4:

                                stocktrannsactionsconnectivity
                                        .getallstocktransactions();

                                break;


                            case 5:

                                break;


                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (stockTransactionOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 12. EXPIRY ALERTS
                // =================================================

                case 12:

                    while (true) {

                        System.out.println();
                        System.out.println("======================================");
                        System.out.println("          EXPIRY ALERT MENU");
                        System.out.println("======================================");

                        System.out.println("1. Insertion");
                        System.out.println("2. Update");
                        System.out.println("3. Delete");
                        System.out.println("4. All");
                        System.out.println("5. Back");

                        System.out.print(
                                "Enter your option: "
                        );

                        int expiryAlertOption =
                                sc.nextInt();

                        switch (expiryAlertOption) {

                            case 1:

                                Expiryalerts expiryalert =
                                        new Expiryalerts();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int expiryBatchId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter alert type: "
                                );

                                String alertType =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter alert date (YYYY-MM-DD): "
                                );

                                String alertDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String expiryAlertStatus =
                                        sc.nextLine();

                                expiryalert.setBatchId(
                                        expiryBatchId
                                );

                                expiryalert.setAlertType(
                                        alertType
                                );

                                expiryalert.setAlertDate(
                                        LocalDate.parse(
                                                alertDateInput
                                        )
                                );

                                expiryalert.setStatus(
                                        expiryAlertStatus
                                );

                                expiryalertsconnectivity
                                        .insertexpiryalert(
                                                expiryalert
                                        );

                                break;


                            case 2:

                                Expiryalerts updateExpiryAlert =
                                        new Expiryalerts();

                                System.out.print(
                                        "Enter alert ID to update: "
                                );

                                int updateAlertId =
                                        sc.nextInt();

                                System.out.print(
                                        "Enter batch ID: "
                                );

                                int updateExpiryBatchId =
                                        sc.nextInt();

                                sc.nextLine();

                                System.out.print(
                                        "Enter alert type: "
                                );

                                String updateAlertType =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter alert date (YYYY-MM-DD): "
                                );

                                String updateAlertDateInput =
                                        sc.nextLine();

                                System.out.print(
                                        "Enter status: "
                                );

                                String updateExpiryAlertStatus =
                                        sc.nextLine();

                                updateExpiryAlert.setAlertId(
                                        updateAlertId
                                );

                                updateExpiryAlert.setBatchId(
                                        updateExpiryBatchId
                                );

                                updateExpiryAlert.setAlertType(
                                        updateAlertType
                                );

                                updateExpiryAlert.setAlertDate(
                                        LocalDate.parse(
                                                updateAlertDateInput
                                        )
                                );

                                updateExpiryAlert.setStatus(
                                        updateExpiryAlertStatus
                                );

                                expiryalertsconnectivity
                                        .updateexpiryalert(
                                                updateExpiryAlert
                                        );

                                break;


                            case 3:

                                System.out.print(
                                        "Enter alert ID to delete: "
                                );

                                int deleteAlertId =
                                        sc.nextInt();

                                expiryalertsconnectivity
                                        .deleteexpiryalert(
                                                deleteAlertId
                                        );

                                break;


                            case 4:

                                expiryalertsconnectivity
                                        .getallexpiryalerts();

                                break;


                            case 5:

                                break;


                            default:

                                System.out.println(
                                        "Invalid option"
                                );
                        }

                        if (expiryAlertOption == 5) {
                            break;
                        }
                    }

                    break;


                // =================================================
                // 13. EXIT
                // =================================================

                case 13:

                    sc.close();

                    System.out.println();
                    System.out.println(
                            "Medical System Closed."
                    );

                    return;


                // =================================================
                // INVALID OPTION
                // =================================================

                default:

                    System.out.println(
                            "Invalid option"
                    );
            }
        }
    }
}
