package com.mithilesh.map;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        //creating question object
    //   Question question1 = new Question();
   //     question1.setQuestionId(101);
  //      question1.setQuestion("what is java?");
//
//        Answer answer1=new Answer();
//        answer1.setAnswerId(201);
//        answer1.setAnswer("java is my favourite language");
//        
//        answer1.setQuestion(question1);
//        
//        Answer answer2=new Answer();
//        answer2.setAnswerId(202);
//        answer2.setAnswer("with the help of java we can buid softwares.");
//        
//        answer2.setQuestion(question1);
//        
//        Answer answer3=new Answer();
//        answer3.setAnswerId(203);
//        answer3.setAnswer("java is most secure language..");
//        
//        answer3.setQuestion(question1);
//        
//        List<Answer> list=new ArrayList<Answer>();
//        list.add(answer1);
//        list.add(answer2);
//        list.add(answer3);
//        
//        question1.setAnswers(list);
//        
//        
//        
//       
//        
//        
//        //session
//        
        Session s=factory.openSession();
        
        Transaction tx=s.beginTransaction();
        
        //save
     
//         s.save(question1);
//         s.save(answer1);
//         s.save(answer2);
//         s.save(answer3);
         
        
   Question q=(Question)s.get(Question.class,101);
        
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswers().size());
   
        tx.commit();
        factory.close();
    }

}
