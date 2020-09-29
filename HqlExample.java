
package com.mithilesh.hql;

import com.mithilesh.Student;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session s = factory.openSession();

        String query = "from Student as s where s.city=:x and s.name=:n";
        Query q = s.createQuery(query);
        q.setParameter("x", "bhopal");
        q.setParameter("n", "mithilesh");

        List<Student> list = q.list();
        for (Student student : list) {
            System.out.println(student.getName() + " : " + student.getCertificate().getCourse());

        }

        System.out.println("________________________________________________");
        Transaction tx = s.beginTransaction();
//         Query q2=s.createQuery("delete from Student as s where s.city=:c");
//         q2.setParameter("c","bhopal");
//         
//         int r=q2.executeUpdate();
//         System.out.println("deleted");
//         System.out.println(r);
//         

//        Query q3=s.createQuery("update from Student as s set s.city=:c where s.name=:n");
//        q3.setParameter("c","delhi");
//        q3.setParameter("n","rani");
//        int r=q3.executeUpdate();
//        System.out.println(r+" : "+"updated");
        Query q4 = s.createQuery("select q.question,q.questionId,a.answer from Question as q inner join q.answers as a");

        List<Object[]> list1 = q4.getResultList();
        for (Object[] arr : list1) {
            System.out.println(Arrays.toString(arr));
        }

        tx.commit();
        s.close();
        factory.close();

    }

}