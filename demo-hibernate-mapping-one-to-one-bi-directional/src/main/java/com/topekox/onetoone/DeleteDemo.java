package com.topekox.onetoone;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BiodataAktor.class)
                .addAnnotatedClass(Aktor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 5;
            // menggunakan Optional
            Optional<Aktor> aktor = Optional.ofNullable(session.get(Aktor.class, id));
            aktor.ifPresent(value -> session.delete(value));

//            Cara Manual:

//            Aktor aktor = session.get(Aktor.class, id);
//            if (aktor != null) {
//                System.out.println("Deleting");
//                session.delete(aktor);
//            }

            session.getTransaction().commit();
            System.out.println("\nDONE!!!!");
        } finally {
            sessionFactory.close();
        }
    }
}
