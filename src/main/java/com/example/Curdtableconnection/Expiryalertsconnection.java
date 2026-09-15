package com.example.Curdtableconnection;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Expiryalerts;
import com.example.HibernateUtil;

public class Expiryalertsconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Expiry Alert");
            System.out.println("2. View Expiry Alert");
            System.out.println("3. View All Expiry Alerts");
            System.out.println("4. Update Expiry Alert");
            System.out.println("5. Delete Expiry Alert");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            // ADD
            if (choice == 1) {

                System.out.print("Batch ID: ");
                int batchId = sc.nextInt();

                sc.nextLine();

                System.out.print("Alert type: ");
                String alertType = sc.nextLine();

                System.out.print("Alert date (YYYY-MM-DD): ");
                LocalDate alertDate =
                        LocalDate.parse(sc.nextLine());

                System.out.print("Status: ");
                String status = sc.nextLine();


                Expiryalerts alert =
                        new Expiryalerts(
                                batchId,
                                alertType,
                                alertDate,
                                status
                        );


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(alert);

                tx.commit();

                session.close();

                System.out.println("Expiry alert added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter alert ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Expiryalerts alert =
                        session.find(Expiryalerts.class, id);

                if (alert != null) {
                    System.out.println(alert);
                } else {
                    System.out.println("Alert not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Expiryalerts> list =
                        session.createQuery(
                                "from Expiryalerts",
                                Expiryalerts.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No expiry alerts found!");
                } else {

                    for (Expiryalerts alert : list) {
                        System.out.println(alert);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter alert ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Expiryalerts alert =
                        session.find(Expiryalerts.class, id);

                if (alert != null) {

                    System.out.print("New batch ID: ");
                    alert.setBatchId(sc.nextInt());

                    sc.nextLine();

                    System.out.print("New alert type: ");
                    alert.setAlertType(sc.nextLine());

                    System.out.print("New alert date (YYYY-MM-DD): ");
                    alert.setAlertDate(
                            LocalDate.parse(sc.nextLine())
                    );

                    System.out.print("New status: ");
                    alert.setStatus(sc.nextLine());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Expiry alert updated!");

                } else {

                    System.out.println("Alert not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter alert ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Expiryalerts alert =
                        session.find(Expiryalerts.class, id);

                if (alert != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(alert);

                    tx.commit();

                    System.out.println("Expiry alert deleted!");

                } else {

                    System.out.println("Alert not found!");
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
