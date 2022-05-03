package com.topekox.demo.hibernate.demo;

import com.topekox.demo.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryPerson {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // display list
            System.out.println("\nDaftar Person:");
            List<Person> people = session.createQuery("FROM Person", Person.class).getResultList();
            displayPerson(people);

            // display by last name
            System.out.println("\nData Person by Last Name:");
            people = session.createQuery("FROM Person p WHERE p.lastName='Hatake'").getResultList();
            displayPerson(people);

            // display by last name
            System.out.println("\nData Person by Email:");
            people = session.createQuery("FROM Person p WHERE p.email LIKE '%@jojo.com'").getResultList();
            displayPerson(people);

            session.getTransaction().commit();
            System.out.println("DONE!!!!");
        } finally {
            sessionFactory.close();
        }
    }

    private static void displayPerson(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

}
