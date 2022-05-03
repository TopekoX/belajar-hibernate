package com.topekox.demo.hibernate.demo;

import com.topekox.demo.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdatePerson {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 4;

            System.out.println("\nUpdate 1 Person:");
            Person person = session.get(Person.class, id);
            person.setFirstName("Neji");
            person.setLastName("Hyuga");
            person.setEmail("neji@naruto.com");

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nUpdate all Person by Email");
            session.createQuery("UPDATE Person SET email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("DONE!!!!");
        } finally {
            sessionFactory.close();
        }
    }

}
