package com.mithilesh.state;

import com.mithilesh.Certificate;
import com.mithilesh.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

    public static void main(String[] args) {
        
        //practical session for state demo
        
//        Transient
//        Persistent
//        Detached
//        Removed
        
        System.out.println("mithilesh");
        
        SessionFactory f=new Configuration().configure().buildSessionFactory();
        
//        creating student object
          Student s=new Student();

          s.setId(102);
          s.setName("mithilesh");
          s.setCity("singrauli");
          s.setCertificate(new Certificate("hibernate course","2 months"));
          
//         now student object is in transient state

          Session session=f.openSession();
          Transaction tx=session.beginTransaction();
          session.save(s);
          
//          now student object is in persistent state-associated with session and database as well

          
          s.setName("rani");
          tx.commit();
          
//          session.close();
          
//          now student object is in detached state-associted with only database
        

         Student s1=(Student)session.load(Student.class,102);
         
         session.delete(s);
         System.out.println(s1);
         
//          s.setName("raja");
//          System.out.println(s);
        
        f.close();

    }
    
    
}
