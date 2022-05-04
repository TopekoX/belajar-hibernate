package com.topekox.onetoone;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

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

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            int id = 4;
            // Menggunakan Optional
            Optional<BiodataAktor> biodataAktor = Optional.ofNullable(session.get(BiodataAktor.class, id));
            biodataAktor.ifPresent(value -> {
                System.out.println("\nBiodata Aktor....");
                System.out.println("Biodata aktor : " + value + " - " +
                        value.getAktor());
            } );

            session.getTransaction().commit();
            System.out.println("\nDONE!!!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
