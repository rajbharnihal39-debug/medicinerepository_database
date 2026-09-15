package com.example.Curdtableconnection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Medicinebatches;
import com.example.HibernateUtil;

public class Medicinebatchesconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Batch");
            System.out.println("2. View Batch");
            System.out.println("3. View All Batches");
            System.out.println("4. Update Batch");
            System.out.println("5. Delete Batch");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // ADD
            if (choice == 1) {

                System.out.print("Medicine ID: ");
                int medicineId = sc.nextInt();

                System.out.print("Supplier ID: ");
                int supplierId = sc.nextInt();

                sc.nextLine();

                System.out.print("Batch number: ");
                String batchNumber = sc.nextLine();

                System.out.print("Manufacture date (YYYY-MM-DD): ");
                LocalDate manufactureDate =
                        LocalDate.parse(sc.nextLine());

                System.out.print("Expiry date (YYYY-MM-DD): ");
                LocalDate expiryDate =
                        LocalDate.parse(sc.nextLine());

                System.out.print("Purchase price: ");
                BigDecimal purchasePrice = sc.nextBigDecimal();

                System.out.print("Selling price: ");
                BigDecimal sellingPrice = sc.nextBigDecimal();

                System.out.print("Quantity received: ");
                int quantityReceived = sc.nextInt();

                System.out.print("Quantity available: ");
                int quantityAvailable = sc.nextInt();


                Medicinebatches batch = new Medicinebatches(
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


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(batch);

                tx.commit();

                session.close();

                System.out.println("Batch added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter batch ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicinebatches batch =
                        session.find(Medicinebatches.class, id);

                if (batch != null) {
                    System.out.println(batch);
                } else {
                    System.out.println("Batch not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Medicinebatches> list =
                        session.createQuery(
                                "from Medicinebatches",
                                Medicinebatches.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No batches found!");
                } else {

                    for (Medicinebatches batch : list) {
                        System.out.println(batch);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter batch ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicinebatches batch =
                        session.find(Medicinebatches.class, id);

                if (batch != null) {

                    System.out.print("New purchase price: ");
                    batch.setPurchasePrice(sc.nextBigDecimal());

                    System.out.print("New selling price: ");
                    batch.setSellingPrice(sc.nextBigDecimal());

                    System.out.print("New quantity received: ");
                    batch.setQuantityReceived(sc.nextInt());

                    System.out.print("New quantity available: ");
                    batch.setQuantityAvailable(sc.nextInt());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Batch updated!");

                } else {

                    System.out.println("Batch not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter batch ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicinebatches batch =
                        session.find(Medicinebatches.class, id);

                if (batch != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(batch);

                    tx.commit();

                    System.out.println("Batch deleted!");

                } else {

                    System.out.println("Batch not found!");
                }

                session.close();
            }


            // EXIT
            else if (choice == 6) {

                break;

            } else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
        factory.close();

        System.out.println("Application closed.");
    }
}
