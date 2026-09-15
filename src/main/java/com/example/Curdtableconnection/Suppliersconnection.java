package com.example.Curdtableconnection;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Suppliers;
import com.example.HibernateUtil;

public class Suppliersconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Supplier");
            System.out.println("2. View Supplier");
            System.out.println("3. View All Suppliers");
            System.out.println("4. Update Supplier");
            System.out.println("5. Delete Supplier");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // ADD
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Supplier code: ");
                String code = sc.nextLine();

                System.out.print("Supplier name: ");
                String name = sc.nextLine();

                System.out.print("Contact person: ");
                String contact = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                System.out.print("GST number: ");
                String gst = sc.nextLine();

                System.out.print("Status: ");
                String status = sc.nextLine();


                Suppliers supplier = new Suppliers(
                        code,
                        name,
                        contact,
                        phone,
                        email,
                        address,
                        gst,
                        status
                );


                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(supplier);

                tx.commit();

                session.close();

                System.out.println("Supplier added!");
            }


            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter supplier ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Suppliers supplier =
                        session.find(Suppliers.class, id);

                if (supplier != null) {
                    System.out.println(supplier);
                } else {
                    System.out.println("Supplier not found!");
                }

                session.close();
            }


            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Suppliers> list =
                        session.createQuery(
                                "from Suppliers",
                                Suppliers.class
                        ).getResultList();

                for (Suppliers supplier : list) {
                    System.out.println(supplier);
                }

                session.close();
            }


            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter supplier ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                Session session = factory.openSession();

                Suppliers supplier =
                        session.find(Suppliers.class, id);

                if (supplier != null) {

                    System.out.print("New supplier name: ");
                    supplier.setName(sc.nextLine());

                    System.out.print("New contact person: ");
                    supplier.setContactPerson(sc.nextLine());

                    System.out.print("New phone: ");
                    supplier.setPhone(sc.nextLine());

                    System.out.print("New email: ");
                    supplier.setEmail(sc.nextLine());

                    System.out.print("New address: ");
                    supplier.setAddress(sc.nextLine());

                    System.out.print("New GST number: ");
                    supplier.setGstNumber(sc.nextLine());

                    System.out.print("New status: ");
                    supplier.setStatus(sc.nextLine());


                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Supplier updated!");
                } else {

                    System.out.println("Supplier not found!");
                }

                session.close();
            }


            // DELETE
            else if (choice == 5) {

                System.out.print("Enter supplier ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Suppliers supplier =
                        session.find(Suppliers.class, id);

                if (supplier != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(supplier);

                    tx.commit();

                    System.out.println("Supplier deleted!");

                } else {

                    System.out.println("Supplier not found!");
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
