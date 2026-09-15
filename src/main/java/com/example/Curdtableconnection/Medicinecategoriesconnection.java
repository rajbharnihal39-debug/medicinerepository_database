package com.example.Curdtableconnection;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Medicinecategories;
import com.example.HibernateUtil;

public class Medicinecategoriesconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MEDICINE CATEGORY MENU =====");
            System.out.println("1. Add Category");
            System.out.println("2. View Category");
            System.out.println("3. View All Categories");
            System.out.println("4. Update Category");
            System.out.println("5. Delete Category");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // CREATE
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Enter category name: ");
                String name = sc.nextLine();

                System.out.print("Enter description: ");
                String description = sc.nextLine();

                Medicinecategories category =
                        new Medicinecategories(name, description);

                Session session = factory.openSession();

                Transaction tx = session.beginTransaction();

                session.persist(category);

                tx.commit();
                session.close();

                System.out.println("Category added successfully!");
            }

            // READ ONE
            else if (choice == 2) {

                System.out.print("Enter category ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicinecategories category =
                        session.find(Medicinecategories.class, id);

                if (category != null) {
                    System.out.println(category);
                } else {
                    System.out.println("Category not found!");
                }

                session.close();
            }

            // READ ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Medicinecategories> categories =
                        session.createQuery(
                                "from Medicinecategories",
                                Medicinecategories.class
                        ).getResultList();

                if (categories.isEmpty()) {

                    System.out.println("No categories found!");

                } else {

                    for (Medicinecategories category : categories) {
                        System.out.println(category);
                    }
                }

                session.close();
            }

            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter category ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                Session session = factory.openSession();

                Medicinecategories category =
                        session.find(Medicinecategories.class, id);

                if (category != null) {

                    System.out.print("Enter new category name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new description: ");
                    String description = sc.nextLine();

                    Transaction tx = session.beginTransaction();

                    category.setCategoryName(name);
                    category.setDescription(description);

                    tx.commit();

                    System.out.println("Category updated successfully!");

                } else {

                    System.out.println("Category not found!");
                }

                session.close();
            }

            // DELETE
            else if (choice == 5) {

                System.out.print("Enter category ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Medicinecategories category =
                        session.find(Medicinecategories.class, id);

                if (category != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(category);

                    tx.commit();

                    System.out.println("Category deleted successfully!");

                } else {

                    System.out.println("Category not found!");
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
