package com.topekox.onetoone;

import com.topekox.entity.Aktor;
import com.topekox.entity.BiodataAktor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BiodataAktor.class)
                .addAnnotatedClass(Aktor.class)
                .buildSessionFactory();
        
        Session session = sessionFactory.getCurrentSession();
        
        try {
        	// membuat aktor
        	System.out.println("\nMembuat Aktor...");
        	Aktor aktor = new Aktor("Rano", "Karno", "ranokarno@gmail.com");
        	
        	BiodataAktor biodataAktor = new BiodataAktor("Bantem", "@ranokarno", "Politik");
        	aktor.setBiodataAktor(biodataAktor);
        	
        	session.beginTransaction();
        	System.out.println("\nSaving Aktor...");
        	
        	session.save(aktor);
        	
        	session.getTransaction().commit();
        	System.out.println("\nDONE!!!!");        	
        } finally {
			sessionFactory.close();
		}
    }

}
