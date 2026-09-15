package com.example.Curdtableconnection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Stocktransactions;
import com.example.HibernateUtil;

public class Stocktransactionsconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Stock Transaction");
            System.out.println("2. View Stock Transaction");
            System.out.println("3. View All Stock Transactions");
            System.out.println("4. Update Stock Transaction");
            System.out.println("5. Delete Stock Transaction");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            // ADD
            if (choice == 1) {

                System.out.print("Medicine ID: ");
                int medicineId = sc.nextInt();

                System.out.print("Batch ID: ");
                int batchId = sc.nextInt();

                sc.nextLine();

                System.out.print("Transaction type: ");
                String transactionType = sc.nextLine();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                sc.nextLine();

                System.out.print("Reference type: ");
                String referenceType = sc.nextLine();

                System.out.print("Reference ID: ");
                int referenceId = sc.nextInt();

                sc.nextLine();

                System.out.print("Transaction date (YYYY-MM-DDTHH:MM:SS): ");
                LocalDateTime transactionDate =
                        LocalDateTime.parse(sc.nextLine());

                System.out.print("Notes: ");
                String notes = sc.nextLine();

                System.out.print("Created by: ");
                int createdBy = sc.nextInt();


                Stocktransactions transaction =
                        new Stocktransactions(
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


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(transaction);

                tx.commit();

                session.close();

                System.out.println("Stock transaction added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter transaction ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Stocktransactions transaction =
                        session.find(Stocktransactions.class, id);

                if (transaction != null) {
                    System.out.println(transaction);
                } else {
                    System.out.println("Transaction not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Stocktransactions> list =
                        session.createQuery(
                                "from Stocktransactions",
                                Stocktransactions.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No transactions found!");
                } else {

                    for (Stocktransactions transaction : list) {
                        System.out.println(transaction);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter transaction ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Stocktransactions transaction =
                        session.find(Stocktransactions.class, id);

                if (transaction != null) {

                    System.out.print("New transaction type: ");
                    sc.nextLine();
                    transaction.setTransactionType(sc.nextLine());

                    System.out.print("New quantity: ");
                    transaction.setQuantity(sc.nextInt());

                    System.out.print("New reference type: ");
                    sc.nextLine();
                    transaction.setReferenceType(sc.nextLine());

                    System.out.print("New reference ID: ");
                    transaction.setReferenceId(sc.nextInt());

                    sc.nextLine();

                    System.out.print("New transaction date (YYYY-MM-DDTHH:MM:SS): ");
                    transaction.setTransactionDate(
                            LocalDateTime.parse(sc.nextLine())
                    );

                    System.out.print("New notes: ");
                    transaction.setNotes(sc.nextLine());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Stock transaction updated!");

                } else {

                    System.out.println("Transaction not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter transaction ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Stocktransactions transaction =
                        session.find(Stocktransactions.class, id);

                if (transaction != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(transaction);

                    tx.commit();

                    System.out.println("Stock transaction deleted!");

                } else {

                    System.out.println("Transaction not found!");
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
