package com.example.Curdtableconnection;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Medicine;
import com.example.HibernateUtil;

public class Medicineconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Medicine");
            System.out.println("2. View Medicine");
            System.out.println("3. View All Medicines");
            System.out.println("4. Update Medicine");
            System.out.println("5. Delete Medicine");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // ADD
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Medicine code: ");
                String code = sc.nextLine();

                System.out.print("Medicine name: ");
                String name = sc.nextLine();

                System.out.print("Generic name: ");
                String generic = sc.nextLine();

                System.out.print("Category ID: ");
                int category = sc.nextInt();
                sc.nextLine();

                System.out.print("Dosage form: ");
                String dosage = sc.nextLine();

                System.out.print("Strength: ");
                String strength = sc.nextLine();

                System.out.print("Unit: ");
                String unit = sc.nextLine();

                System.out.print("Record level: ");
                int record = sc.nextInt();
                sc.nextLine();

                System.out.print("Description: ");
                String description = sc.nextLine();

                System.out.print("Status: ");
                String status = sc.nextLine();

                Medicine medicine = new Medicine(
                        code, name, generic, category,
                        dosage, strength, unit,
                        record, description, status
                );

                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();

                session.persist(medicine);

                tx.commit();
                session.close();

                System.out.println("Medicine added!");
            }

            // VIEW ONE
            else if (choice == 2) {

                System.out.print("Enter medicine ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicine medicine =
                        session.find(Medicine.class, id);

                if (medicine != null) {
                    System.out.println(medicine);
                } else {
                    System.out.println("Medicine not found!");
                }

                session.close();
            }

            // VIEW ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Medicine> list =
                        session.createQuery(
                                "from Medicine",
                                Medicine.class
                        ).getResultList();

                for (Medicine medicine : list) {
                    System.out.println(medicine);
                }

                session.close();
            }

            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter medicine ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                Session session = factory.openSession();

                Medicine medicine =
                        session.find(Medicine.class, id);

                if (medicine != null) {

                    System.out.print("New medicine name: ");
                    medicine.setName(sc.nextLine());

                    System.out.print("New generic name: ");
                    medicine.setGenericName(sc.nextLine());

                    System.out.print("New strength: ");
                    medicine.setStrength(sc.nextLine());

                    System.out.print("New description: ");
                    medicine.setDescription(sc.nextLine());

                    System.out.print("New status: ");
                    medicine.setStatus(sc.nextLine());

                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("Medicine updated!");

                } else {

                    System.out.println("Medicine not found!");
                }

                session.close();
            }

            // DELETE
            else if (choice == 5) {

                System.out.print("Enter medicine ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicine medicine =
                        session.find(Medicine.class, id);

                if (medicine != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(medicine);

                    tx.commit();

                    System.out.println("Medicine deleted!");

                } else {

                    System.out.println("Medicine not found!");
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
