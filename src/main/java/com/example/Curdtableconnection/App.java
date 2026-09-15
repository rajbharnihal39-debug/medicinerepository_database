package com.example.Curdtableconnection;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Role;
import com.example.HibernateUtil;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Role");
            System.out.println("2. View Role");
            System.out.println("3. View All Roles");
            System.out.println("4. Update Role");
            System.out.println("5. Delete Role");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // CREATE
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Enter role name: ");
                String name = sc.nextLine();

                System.out.print("Enter description: ");
                String description = sc.nextLine();

                Role role = new Role(name, description);

                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();

                session.persist(role);

                tx.commit();
                session.close();

                System.out.println("Role added successfully!");
            }

            // READ ONE
            else if (choice == 2) {

                System.out.print("Enter role ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Role role = session.find(Role.class, id);

                if (role != null) {
                    System.out.println(role);
                } else {
                    System.out.println("Role not found!");
                }

                session.close();
            }

            // READ ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<Role> roles =
                        session.createQuery("from Role", Role.class)
                               .getResultList();

                for (Role role : roles) {
                    System.out.println(role);
                }

                session.close();
            }

            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter role ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                Session session = factory.openSession();

                Role role = session.find(Role.class, id);

                if (role != null) {

                    System.out.print("Enter new role name: ");
                    role.setRoleName(sc.nextLine());

                    System.out.print("Enter new description: ");
                    role.setDescription(sc.nextLine());

                    Transaction tx = session.beginTransaction();

                    session.merge(role);

                    tx.commit();

                    System.out.println("Role updated successfully!");

                } else {

                    System.out.println("Role not found!");
                }

                session.close();
            }

            // DELETE
            else if (choice == 5) {

                System.out.print("Enter role ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                Role role = session.find(Role.class, id);

                if (role != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(role);

                    tx.commit();

                    System.out.println("Role deleted successfully!");

                } else {

                    System.out.println("Role not found!");
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
