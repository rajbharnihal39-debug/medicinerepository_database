package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Entity.Expiryalerts;
import com.example.Entity.Medicine;
import com.example.Entity.Medicinebatches;
import com.example.Entity.Medicinecategories;
import com.example.Entity.Purchaseorderitems;
import com.example.Entity.Purchaseorders;
import com.example.Entity.Role;
import com.example.Entity.Saleitems;
import com.example.Entity.Sales;
import com.example.Entity.Stocktransactions;
import com.example.Entity.Suppliers;
import com.example.Entity.User;

public class HibernateUtil {

    private static final SessionFactory sessionFactory =
            new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Role.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Medicinecategories.class)
                    .addAnnotatedClass(Medicine.class)
                    .addAnnotatedClass(Suppliers.class)
                    .addAnnotatedClass(Medicinebatches.class)
                    .addAnnotatedClass(Purchaseorders.class)
                    .addAnnotatedClass(Purchaseorderitems.class)
                    .addAnnotatedClass(Sales.class)
                    .addAnnotatedClass(Saleitems.class)
                    .addAnnotatedClass(Stocktransactions.class)
                    .addAnnotatedClass(Expiryalerts.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
