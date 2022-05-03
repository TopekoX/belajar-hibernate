package com.topekox.demo.hibernate.demo;

import com.topekox.demo.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMultiplePerson {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        try {
            System.out.println("create 3 person");
            Person person1 = new Person("Eren", "Yeager", "eren@aot.com");
            Person person2 = new Person("Mikasa", "Ackerman", "mikasa@aot.com");
            Person person3 = new Person("Armin", "Alert", "armin@aot.com");

            System.out.println("Savingg......");
            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            sessionFactory.close();
        }
    }

}
