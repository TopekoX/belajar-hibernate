package com.topekox.demo.hibernate.demo;

import com.topekox.demo.hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePerson {

    public static void main(String[] args) {
    
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
        
        Session session = sessionFactory.getCurrentSession();
                
        session.beginTransaction();

        try {
            System.out.println("create new person");
            Person person = new Person("Kakasi", "Hatake", "kakasi@naruto.com");

            session.save(person);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            sessionFactory.close();
        }
    }
    
}
