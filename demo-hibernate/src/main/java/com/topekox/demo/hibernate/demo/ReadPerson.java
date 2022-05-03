package com.topekox.demo.hibernate.demo;

import com.topekox.demo.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadPerson {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Kotaro", "Kujo", "kotaro@jojo.com");

            session.save(person);

            session.getTransaction().commit();
            System.out.println("Done!!! Person telah disimpan dengan Id : " + person.getId());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person jojo = session.get(Person.class, person.getId());
            System.out.println("Person Read : " + jojo);

            session.getTransaction().commit();
            System.out.println("DONE!!!!");
        } finally {
            sessionFactory.close();
        }
    }

}
