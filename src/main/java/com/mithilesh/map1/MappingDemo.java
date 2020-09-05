package com.mithilesh.map1;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Employee emp1=new Employee();
        Employee emp2=new Employee();
        Employee emp3=new Employee();
        
        emp1.seteId(101);
        emp1.seteName("mithilesh");
        
        emp2.seteId(102);
        emp2.seteName("sunil");
        
        emp3.seteId(103);
        emp3.seteName("rahul");
        
        
        Project p1=new Project();
        Project p2=new Project();
        Project p3=new Project();
        
        p1.setpId(201);
        p1.setpName("java");
        
        p2.setpId(202);
        p2.setpName("python");
        
        p3.setpId(203);
        p3.setpName("data structure");
        
        
        List<Employee> l1=new ArrayList<Employee>();
        List<Project> l2=new ArrayList<Project>();
        
        l1.add(emp1);
        l1.add(emp2);
        l1.add(emp3);
        
        l2.add(p1);
        l2.add(p2);
        l2.add(p3);
        
        emp1.setProjects(l2);
        
        p2.setEmployees(l1);
        
        Session s=factory.openSession();
        
        Transaction tx=s.beginTransaction();
        
        s.save(emp1);
        s.save(emp2);
        s.save(emp3);
        
        s.save(p1);
        s.save(p2);
        s.save(p3);
        
        
        
        
        tx.commit();
        s.close();
        factory.close();
    }
}
