package com.topekox.onetoone;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BiodataAktor.class)
                .addAnnotatedClass(Aktor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Aktor> aktors = session.createQuery("from Aktor").getResultList();

            System.out.println("\nDaftar Aktor....");
            for (Aktor aktor : aktors) {
                System.out.println(aktor + " - " + aktor.getBiodataAktor());
            }

            session.getTransaction().commit();
            System.out.println("\nDONE!!!");
        } finally {
            sessionFactory.close();
        }
    }
}
