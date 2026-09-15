package com.example.Curdtableconnection;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Saleitems;
import com.example.HibernateUtil;

public class Saleitemsconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Sale Item");
            System.out.println("2. View Sale Item");
            System.out.println("3. View All Sale Items");
            System.out.println("4. Update Sale Item");
            System.out.println("5. Delete Sale Item");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            // ADD
            if (choice == 1) {

                System.out.print("Sale ID: ");
                int saleId = sc.nextInt();

                System.out.print("Medicine ID: ");
                int medicineId = sc.nextInt();

                System.out.print("Batch ID: ");
                int batchId = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Unit price: ");
                BigDecimal unitPrice = sc.nextBigDecimal();

                System.out.print("Discount: ");
                BigDecimal discount = sc.nextBigDecimal();

                System.out.print("Tax: ");
                BigDecimal tax = sc.nextBigDecimal();

                System.out.print("Total amount: ");
                BigDecimal totalAmount = sc.nextBigDecimal();


                Saleitems item = new Saleitems(
                        saleId,
                        medicineId,
                        batchId,
                        quantity,
                        unitPrice,
                        discount,
                        tax,
                        totalAmount
                );


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(item);

                tx.commit();

                session.close();

                System.out.println("Sale item added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter sale item ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Saleitems item =
                        session.find(Saleitems.class, id);

                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Sale item not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Saleitems> list =
                        session.createQuery(
                                "from Saleitems",
                                Saleitems.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No sale items found!");
                } else {

                    for (Saleitems item : list) {
                        System.out.println(item);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter sale item ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Saleitems item =
                        session.find(Saleitems.class, id);

                if (item != null) {

                    System.out.print("New quantity: ");
                    item.setQuantity(sc.nextInt());

                    System.out.print("New unit price: ");
                    item.setUnitPrice(sc.nextBigDecimal());

                    System.out.print("New discount: ");
                    item.setDiscount(sc.nextBigDecimal());

                    System.out.print("New tax: ");
                    item.setTax(sc.nextBigDecimal());

                    System.out.print("New total amount: ");
                    item.setTotalAmount(sc.nextBigDecimal());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Sale item updated!");

                } else {

                    System.out.println("Sale item not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter sale item ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Saleitems item =
                        session.find(Saleitems.class, id);

                if (item != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(item);

                    tx.commit();

                    System.out.println("Sale item deleted!");

                } else {

                    System.out.println("Sale item not found!");
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
