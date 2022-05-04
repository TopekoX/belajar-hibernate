package com.topekox.onetomany;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;
import com.topekox.entity.Film;
import com.topekox.entity.Produser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
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
            System.out.println("\nSaving Produser...");

            System.out.println("\nMembuat Produser...");
            Produser produser1 = new Produser("PT. Parkit Films", "Jakarta");
            Produser produser2 = new Produser("PT. RAPI Films", "Jakarta");
            Produser produser3 = new Produser("PT. Soraya", "Jakarta");

            System.out.println("\nMembuat Film...");
            Film film1 = new Film("Maju Kena Mundur Kena");
            Film film2 = new Film("Jaka Sembung");
            Film film3 = new Film("Malam Satu Suro");
            Film film4 = new Film("Ratu Buaya Putih");
            Film film5 = new Film("Setan Kredit");

            session.save(produser1);
            session.save(produser2);
            session.save(produser3);

            produser1.add(film1);
            produser1.add(film5);
            produser2.add(film2);
            produser3.add(film3);
            produser3.add(film4);

            session.save(film1);
            session.save(film2);
            session.save(film3);
            session.save(film4);
            session.save(film5);

            session.getTransaction().commit();
            System.out.println("\nDONE!!!!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
