/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import onlineexam.entity.Exam;
import onlineexam.entity.Subjects;
import onlineexam.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class ExamDAOImpl implements ExamDAO{

    private static SessionFactory sf=HibernateUtils.getSessionFactory();
    private static Session sess=null;
    private static Exam e=null;
    private static Transaction tx=null;
    
    @Override
    public Exam getExamDetails() {
        try{
            System.out.println("Opening session...");
        sess=sf.openSession();
            System.out.println("Opening transaction...");
        tx=sess.beginTransaction();
            System.out.println("this is transaction "+tx);
        e=new Exam();
        sess.save(e);
        return e;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Subjects> getSubjectDetails() {
        Session sess=HibernateUtils.getSessionFactory().openSession();
        Query<Subjects> qry=sess.createQuery("from Subjects");
        ArrayList<Subjects> subjectList=new ArrayList<>();
        List<Subjects> list=qry.list();
        Iterator<Subjects> it=list.iterator();
        while(it.hasNext())
        {
            Subjects s=it.next();
            subjectList.add(s);
        }
        sess.close();
        return subjectList;
    }

    @Override
    public void setExam(Exam e) {
    this.e=e;
    System.out.println("Exam details in ExamDAOImpl first setExam(Exam e):"+this.e);
//    if(tx!=null && sess!=null)
    {
//        try{
            System.out.println("Exam details in ExamDAOImpl setExam(Exam e):"+this.e);
            sess.update(this.e);
//        System.out.println("Commiting transaction........");
//        tx.commit();
//        System.out.println("Closing session......");
//        sess.close();
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
    }
    }
    public void commitExam()
    {
         System.out.println("Commiting transaction........");
        tx.commit();
        System.out.println("Closing session......");
        sess.close();
    }

    @Override
    public String getSubjectByExamId(int examId) {
       Session sess=HibernateUtils.getSessionFactory().openSession();
       Query qry=sess.createQuery("from Exam where examId=:eid");
       qry.setParameter("eid", examId);
       Exam str=(Exam)qry.getSingleResult();
        System.out.println("from examDAOImple "+str.getSubjectId());
        sess.close();
       return str.getSubjectId();
    }
    
}
