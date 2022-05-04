package com.topekox.onetomany;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import com.topekox.entity.Film;
import com.topekox.entity.Produser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo {
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

            Produser produser = session.get(Produser.class, 3);

            System.out.println("\nProduser : " + produser);

            System.out.println("\nFilm : " + produser.getFilms());

            session.getTransaction().commit();
            System.out.println("\nDONE!!!!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
