package com.mithilesh;

import java.io.FileInputStream;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args){
        try {
            System.out.println("mithilesh kumar shah maven project");

            SessionFactory factory = new Configuration().configure().buildSessionFactory();

            //creating student
            
            Student st=new Student();
            st.setId(102);
            st.setName("pramila");
            st.setCity("gadahara");
            System.out.println(st);
            
            //creating address object
            Address ad=new Address();
            ad.setStreet("sasan");
            ad.setCity("waidhab");
            ad.setIsOpen(true);
            ad.setAddedDate(new Date());
            ad.setX(123.45);
            
          
            
            
            
            Session session=factory.openSession();
            
            Transaction t=session.beginTransaction();
            
            session.save(st);
            session.save(ad);
            t.commit();
            
            
            
            
            session.close();
            
            System.out.println("done");
            
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
