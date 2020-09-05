package com.mithilesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Student st1=new Student();
        st1.setId(201);
        st1.setName("raja");
        st1.setCity("whole world");
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("B.TECH");
        certificate1.setDuration("4 Years");
        
        st1.setCertificate(certificate1);
        
        Student st2=new Student();
        st2.setId(202);
        st2.setName("rani");
        st2.setCity("whole world with raja");
        
        Certificate certificate2=new Certificate();
        certificate2.setCourse("Bsc");
        certificate2.setDuration("3 Years");
        
        st2.setCertificate(certificate2);
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        
//        object save
        
       s.save(st1);
       s.save(st2);
        
        tx.commit();
        s.close();
        factory.close();
    }
    
}
