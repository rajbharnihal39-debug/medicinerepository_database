package com.example.Curdtableconnection;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.Entity.Role;
import com.example.Entity.User;
import com.example.Entity.User.Status;
import com.example.HibernateUtil;

public class Usersconnection {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== USER MANAGEMENT ==========");
            System.out.println("1. Add User");
            System.out.println("2. View User");
            System.out.println("3. View All Users");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            // CREATE
            if (choice == 1) {

                sc.nextLine();

                System.out.print("Enter role ID: ");
                int roleId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                System.out.print("Enter status (Active/Inactive): ");
                String statusInput = sc.nextLine();

                Session session = factory.openSession();

                Role role = session.find(Role.class, roleId);

                if (role == null) {
                    System.out.println("Role not found!");
                    session.close();
                    continue;
                }

                User user = new User(
                        role,
                        name,
                        email,
                        password,
                        Status.valueOf(statusInput)
                );

                Transaction tx = session.beginTransaction();

                session.persist(user);

                tx.commit();
                session.close();

                System.out.println("User added successfully!");
            }

            // READ ONE
            else if (choice == 2) {

                System.out.print("Enter user ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                User user = session.find(User.class, id);

                if (user != null) {
                    System.out.println(user);
                } else {
                    System.out.println("User not found!");
                }

                session.close();
            }

            // READ ALL
            else if (choice == 3) {

                Session session = factory.openSession();

                List<User> users =
                        session.createQuery(
                                "from User",
                                User.class
                        ).getResultList();

                if (users.isEmpty()) {
                    System.out.println("No users found!");
                } else {
                    for (User user : users) {
                        System.out.println(user);
                    }
                }

                session.close();
            }

            // UPDATE
            else if (choice == 4) {

                System.out.print("Enter user ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                Session session = factory.openSession();

                User user = session.find(User.class, id);

                if (user != null) {

                    System.out.print("Enter new role ID: ");
                    int roleId = sc.nextInt();
                    sc.nextLine();

                    Role role = session.find(Role.class, roleId);

                    if (role == null) {
                        System.out.println("Role not found!");
                        session.close();
                        continue;
                    }

                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter new password: ");
                    String password = sc.nextLine();

                    System.out.print("Enter new status (Active/Inactive): ");
                    String statusInput = sc.nextLine();

                    user.setRole(role);
                    user.setName(name);
                    user.setEmail(email);
                    user.setPasswordHash(password);
                    user.setStatus(Status.valueOf(statusInput));

                    Transaction tx = session.beginTransaction();

                    tx.commit();

                    System.out.println("User updated successfully!");

                } else {

                    System.out.println("User not found!");
                }

                session.close();
            }

            // DELETE
            else if (choice == 5) {

                System.out.print("Enter user ID: ");
                int id = sc.nextInt();

                Session session = factory.openSession();

                User user = session.find(User.class, id);

                if (user != null) {

                    Transaction tx = session.beginTransaction();

                    session.remove(user);

                    tx.commit();

                    System.out.println("User deleted successfully!");

                } else {

                    System.out.println("User not found!");
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
