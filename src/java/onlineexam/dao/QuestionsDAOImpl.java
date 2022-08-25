/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import onlineexam.entity.GetExamId;
import onlineexam.entity.Questions;
import onlineexam.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class QuestionsDAOImpl implements QuestionsDAO {
Session session=HibernateUtils.getSessionFactory().openSession();
    @Override
    public boolean addQuestionsList(ArrayList<Questions> questionList) {
        boolean result=false;
        Session sess=HibernateUtils.getSessionFactory().openSession();
        Transaction tx=sess.beginTransaction();
        try{
        for(Questions s:questionList)
        {
            System.out.println("Saving in session...................................");
            sess.save(s);
            System.out.println(s);
        }
            System.out.println("All Questions are saved in sesion.................................!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        tx.commit();
            System.out.println("Commiting from questionsDAoImpl ...................!!!!!!!!!............!!!!!!!!");
            result=true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        finally
        {
            if(sess!=null)
            {
                sess.close();
            System.out.println("Session closed success11111111111111!!!!!!!!!!!!!!!1231214412");
            }
        }
        return result;
    }

    @Override
    public List<Questions> getQuestionsByExam(int examId) {
       
       Query qry=session.createQuery("from Questions q where q.examId=:eid");
       qry.setParameter("eid", examId);
       List<Questions> questionList=qry.list();
       return questionList;
    }

    @Override
    public boolean updateQuestions(List<Questions> questionList) {
//    Session sess=HibernateUtils.getSessionFactory().openSession();
    Transaction tx=session.beginTransaction();
    Iterator<Questions> it=questionList.iterator();
    while(it.hasNext())
    {
        Questions qt=it.next();
        session.update(qt);
    }
    tx.commit();
    session.close();
    return true;
    }

    @Override
    public List<GetExamId> getAllExamId() {
       Session sess=HibernateUtils.getSessionFactory().openSession();
       CriteriaBuilder crb=sess.getCriteriaBuilder();
       CriteriaQuery<GetExamId> crq=crb.createQuery(GetExamId.class);
       Root<Questions> root=crq.from(Questions.class);
       crq.multiselect(root.get("examId"),root.get("subjectId"));
       
       crq.distinct(true);
       Query<GetExamId> qry=sess.createQuery(crq);
       List<GetExamId> list=qry.getResultList();
       sess.close();
       return list;
    }

    @Override
    public ArrayList<GetExamId> getExamIdForStudent(String userId) {
        Session sess=HibernateUtils.getSessionFactory().openSession();
        NativeQuery qry2=sess.createNativeQuery("select exam_id as examid from questions minus select exam_id from performance where user_id=:uid");
        qry2.setParameter("uid", userId);
        List<BigDecimal> examId=qry2.list();
//          System.out.println("size = "+examId.size());
          ExamDAO edo=new ExamDAOImpl();
          ArrayList<GetExamId> examList=new ArrayList<>();
          GetExamId eid=null;
       for(BigDecimal bd:examId)
       {
//           System.out.println("this "+bd);
           eid=new GetExamId(bd.intValue(),edo.getSubjectByExamId(bd.intValue()));
//           System.out.println("value of eid "+eid);
           examList.add(eid);
       }
//        System.out.println("Size of List="+examList.size());
//        examList.stream().forEach((gid) -> {
//        System.out.println(gid.toString());
//    });
       sess.close();
        return examList;
    }

    @Override
    public List<Questions> getQuestionsForStudentByExamId(int examId) {
       Session sess=HibernateUtils.getSessionFactory().openSession();
       Query qry=sess.createQuery("from Questions q where q.examId=:eid");
       qry.setParameter("eid", examId);
       List<Questions> questionList=qry.list();
       sess.close();
       return questionList;
    }
    
}
