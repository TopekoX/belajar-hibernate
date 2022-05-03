package com.topekox.demo.hibernate.demo;

import com.topekox.demo.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePerson {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // cara 1
            session.beginTransaction();

            int id = 8;

            System.out.println("\nMenghapus Person by Object dengan id= " + id);
            Person person = session.get(Person.class, id);
            session.delete(person);

            session.getTransaction().commit();

            // Cara 2
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            id = 9;

            System.out.println("\nMenghapus Person by Query dengan id= " + id);
            session.createQuery("DELETE FROM Person WHERE id=" + id).executeUpdate();

            session.getTransaction().commit();
            System.out.println("DONE!!!!");
        } finally {
            sessionFactory.close();
        }
    }

}
