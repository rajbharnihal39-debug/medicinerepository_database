package com.example.Curdtableconnection;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Purchaseorderitems;
import com.example.HibernateUtil;

public class Purchaseorderitemsconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Purchase Order Item");
            System.out.println("2. View Purchase Order Item");
            System.out.println("3. View All Purchase Order Items");
            System.out.println("4. Update Purchase Order Item");
            System.out.println("5. Delete Purchase Order Item");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            // ADD
            if (choice == 1) {

                System.out.print("Purchase Order ID: ");
                int purchaseOrderId = sc.nextInt();

                System.out.print("Medicine ID: ");
                int medicineId = sc.nextInt();

                System.out.print("Quantity ordered: ");
                int quantityOrdered = sc.nextInt();

                System.out.print("Unit price: ");
                BigDecimal unitPrice = sc.nextBigDecimal();

                System.out.print("Tax: ");
                BigDecimal tax = sc.nextBigDecimal();

                System.out.print("Discount: ");
                BigDecimal discount = sc.nextBigDecimal();

                System.out.print("Total amount: ");
                BigDecimal totalAmount = sc.nextBigDecimal();


                Purchaseorderitems item = new Purchaseorderitems(
                        purchaseOrderId,
                        medicineId,
                        quantityOrdered,
                        unitPrice,
                        tax,
                        discount,
                        totalAmount
                );


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(item);

                tx.commit();

                session.close();

                System.out.println("Purchase order item added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter item ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Purchaseorderitems item =
                        session.find(Purchaseorderitems.class, id);

                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Purchaseorderitems> list =
                        session.createQuery(
                                "from Purchaseorderitems",
                                Purchaseorderitems.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No items found!");
                } else {

                    for (Purchaseorderitems item : list) {
                        System.out.println(item);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter item ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Purchaseorderitems item =
                        session.find(Purchaseorderitems.class, id);

                if (item != null) {

                    System.out.print("New quantity ordered: ");
                    item.setQuantityOrdered(sc.nextInt());

                    System.out.print("New unit price: ");
                    item.setUnitPrice(sc.nextBigDecimal());

                    System.out.print("New tax: ");
                    item.setTax(sc.nextBigDecimal());

                    System.out.print("New discount: ");
                    item.setDiscount(sc.nextBigDecimal());

                    System.out.print("New total amount: ");
                    item.setTotalAmount(sc.nextBigDecimal());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Purchase order item updated!");

                } else {

                    System.out.println("Item not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter item ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Purchaseorderitems item =
                        session.find(Purchaseorderitems.class, id);

                if (item != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(item);

                    tx.commit();

                    System.out.println("Purchase order item deleted!");

                } else {

                    System.out.println("Item not found!");
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
