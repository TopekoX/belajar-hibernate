package com.topekox.onetoone;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class DeleteBiDrectionalDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BiodataAktor.class)
                .addAnnotatedClass(Aktor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 3;

            Optional<BiodataAktor> biodataAktor = Optional.ofNullable(session.get(BiodataAktor.class, id));
            biodataAktor.ifPresent(value -> session.delete(value));

            session.getTransaction().commit();
            System.out.println("\nDONE!!!!");
        } finally {
            sessionFactory.close();
        }
    }
}
