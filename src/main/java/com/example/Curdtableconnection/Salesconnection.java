package com.example.Curdtableconnection;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Sales;
import com.example.HibernateUtil;

public class Salesconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Sale");
            System.out.println("2. View Sale");
            System.out.println("3. View All Sales");
            System.out.println("4. Update Sale");
            System.out.println("5. Delete Sale");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            // ADD
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Invoice number: ");
                String invoiceNumber = sc.nextLine();

                System.out.print("Customer name: ");
                String customerName = sc.nextLine();

                System.out.print("Sale date (YYYY-MM-DDTHH:MM:SS): ");
                LocalDateTime saleDate =
                        LocalDateTime.parse(sc.nextLine());

                System.out.print("Subtotal: ");
                BigDecimal subtotal = sc.nextBigDecimal();

                System.out.print("Tax: ");
                BigDecimal tax = sc.nextBigDecimal();

                System.out.print("Discount: ");
                BigDecimal discount = sc.nextBigDecimal();

                System.out.print("Total amount: ");
                BigDecimal totalAmount = sc.nextBigDecimal();

                sc.nextLine();

                System.out.print("Payment method: ");
                String paymentMethod = sc.nextLine();

                System.out.print("Status: ");
                String status = sc.nextLine();

                System.out.print("Created by: ");
                int createdBy = sc.nextInt();


                Sales sale = new Sales(
                        invoiceNumber,
                        customerName,
                        saleDate,
                        subtotal,
                        tax,
                        discount,
                        totalAmount,
                        paymentMethod,
                        status,
                        createdBy
                );


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(sale);

                tx.commit();

                session.close();

                System.out.println("Sale added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter sale ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Sales sale =
                        session.find(Sales.class, id);

                if (sale != null) {
                    System.out.println(sale);
                } else {
                    System.out.println("Sale not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Sales> list =
                        session.createQuery(
                                "from Sales",
                                Sales.class
                        ).getResultList();

                if (list.isEmpty()) {
                    System.out.println("No sales found!");
                } else {

                    for (Sales sale : list) {
                        System.out.println(sale);
                    }
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter sale ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Sales sale =
                        session.find(Sales.class, id);

                if (sale != null) {

                    sc.nextLine();

                    System.out.print("New customer name: ");
                    sale.setCustomerName(sc.nextLine());

                    System.out.print("New subtotal: ");
                    sale.setSubtotal(sc.nextBigDecimal());

                    System.out.print("New tax: ");
                    sale.setTax(sc.nextBigDecimal());

                    System.out.print("New discount: ");
                    sale.setDiscount(sc.nextBigDecimal());

                    System.out.print("New total amount: ");
                    sale.setTotalAmount(sc.nextBigDecimal());

                    sc.nextLine();

                    System.out.print("New payment method: ");
                    sale.setPaymentMethod(sc.nextLine());

                    System.out.print("New status: ");
                    sale.setStatus(sc.nextLine());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Sale updated!");

                } else {

                    System.out.println("Sale not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter sale ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Sales sale =
                        session.find(Sales.class, id);

                if (sale != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(sale);

                    tx.commit();

                    System.out.println("Sale deleted!");

                } else {

                    System.out.println("Sale not found!");
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
