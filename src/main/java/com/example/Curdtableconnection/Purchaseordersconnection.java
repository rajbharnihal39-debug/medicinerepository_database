package com.example.Curdtableconnection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Purchaseorders;
import com.example.HibernateUtil;

public class Purchaseordersconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Purchase Order");
            System.out.println("2. View Purchase Order");
            System.out.println("3. View All Purchase Orders");
            System.out.println("4. Update Purchase Order");
            System.out.println("5. Delete Purchase Order");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // ADD
            if (choice == 1) {

                sc.nextLine();

                System.out.print("PO Number: ");
                String poNumber = sc.nextLine();

                System.out.print("Supplier ID: ");
                int supplierId = sc.nextInt();

                sc.nextLine();

                System.out.print("Order date (YYYY-MM-DD): ");
                LocalDate orderDate =
                        LocalDate.parse(sc.nextLine());

                System.out.print("Expected date (YYYY-MM-DD): ");
                LocalDate expectedDate =
                        LocalDate.parse(sc.nextLine());

                System.out.print("Status: ");
                String status = sc.nextLine();

                System.out.print("Subtotal: ");
                BigDecimal subtotal = sc.nextBigDecimal();

                System.out.print("Tax: ");
                BigDecimal tax = sc.nextBigDecimal();

                System.out.print("Discount: ");
                BigDecimal discount = sc.nextBigDecimal();

                System.out.print("Total amount: ");
                BigDecimal totalAmount = sc.nextBigDecimal();

                sc.nextLine();

                System.out.print("Notes: ");
                String notes = sc.nextLine();


                Purchaseorders order = new Purchaseorders(
                        poNumber,
                        supplierId,
                        orderDate,
                        expectedDate,
                        status,
                        subtotal,
                        tax,
                        discount,
                        totalAmount,
                        notes
                );


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(order);

                tx.commit();

                session.close();

                System.out.println("Purchase order added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter purchase order ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Purchaseorders order =
                        session.find(Purchaseorders.class, id);

                if (order != null) {
                    System.out.println(order);
                } else {
                    System.out.println("Purchase order not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Purchaseorders> list =
                        session.createQuery(
                                "from Purchaseorders",
                                Purchaseorders.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No purchase orders found!");
                } else {

                    for (Purchaseorders order : list) {
                        System.out.println(order);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter purchase order ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Purchaseorders order =
                        session.find(Purchaseorders.class, id);

                if (order != null) {

                    sc.nextLine();

                    System.out.print("New status: ");
                    order.setStatus(sc.nextLine());

                    System.out.print("New subtotal: ");
                    order.setSubtotal(sc.nextBigDecimal());

                    System.out.print("New tax: ");
                    order.setTax(sc.nextBigDecimal());

                    System.out.print("New discount: ");
                    order.setDiscount(sc.nextBigDecimal());

                    System.out.print("New total amount: ");
                    order.setTotalAmount(sc.nextBigDecimal());

                    sc.nextLine();

                    System.out.print("New notes: ");
                    order.setNotes(sc.nextLine());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Purchase order updated!");

                } else {

                    System.out.println("Purchase order not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter purchase order ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Purchaseorders order =
                        session.find(Purchaseorders.class, id);

                if (order != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(order);

                    tx.commit();

                    System.out.println("Purchase order deleted!");

                } else {

                    System.out.println("Purchase order not found!");
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
