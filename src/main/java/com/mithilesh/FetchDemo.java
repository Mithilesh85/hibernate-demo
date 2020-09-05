
package com.mithilesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemo {
    
    public static void main(String[] args) {
        
        //get and load
        
         SessionFactory factory = new Configuration().configure().buildSessionFactory();
         Session session=factory.openSession();
         //get student 101
         
         Student student=(Student)session.load(Student.class,102);
         Student student1=(Student)session.load(Student.class,102);
         System.out.println(student.getName());
         
         //System.out.println(student);
         
//         Address ad=(Address)session.get(Address.class,2);
//        
//         System.out.println(ad.getStreet()+" : "+ad.getCity());
//        
//         Address ad1=(Address)session.get(Address.class,2);
//        
//         System.out.println(ad1.getStreet()+" : "+ad1.getCity());
         
         session.close();
         factory.close();
    }
}
