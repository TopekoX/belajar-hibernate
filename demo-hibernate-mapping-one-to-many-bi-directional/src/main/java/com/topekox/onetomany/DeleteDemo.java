package com.topekox.onetomany;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import com.topekox.entity.Film;
import com.topekox.entity.Produser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BiodataAktor.class)
                .addAnnotatedClass(Aktor.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Produser.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Film film = session.get(Film.class, 14);

            System.out.println("Deleting Film : " + film);
            session.delete(film);

            session.getTransaction().commit();
            System.out.println("\nDONE!!!!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
