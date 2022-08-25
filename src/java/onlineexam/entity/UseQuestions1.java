///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package onlineexam.entity;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.sql.Clob;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import onlineexam.dao.QuestionsDAO;
//import onlineexam.dao.QuestionsDAOImpl;
//
///**
// *
// * @author SHUBHAM MANMOHAN
// */
//public class UseQuestions1 {
//    public static void main(String[] args) {
////        Configuration cfg=new Configuration();
////        cfg.configure("resources/hibernate.cfg.xml");
////        System.out.println("Configuration success...................................");
////        SessionFactory sf=cfg.buildSessionFactory();
////        System.out.println("Session factory build......................");
////        Session sess=sf.openSession();
////        Transaction tx=sess.beginTransaction();
////        System.out.println("Transaction begin................");
////        Scanner kb=new Scanner(System.in);
////        System.out.println("Enter examid:");
////        int eid=kb.nextInt();
////        System.out.println("Enter subject id:");
////        String sid=kb.next();
////        System.out.println("Enter question no:");
////        int qno=kb.nextInt();
////        System.out.println("Enter Question:");
////        String question=kb.next();
////        System.out.println("Enter option 1:");
////        String option1=kb.next();
////        System.out.println("Enter option 2:");
////        String option2=kb.next();
////        System.out.println("Enter option 3:");
////        String option3=kb.next();
////        System.out.println("Enter option 4:");
////        String option4=kb.next();
////        System.out.println("Enter correct option:");
////        String correct=kb.next();
////        System.out.println("Enter marks:");;
////        int marks=kb.nextInt();
////        Questions q1=new Questions();
////        q1.setExamId(eid);
////        q1.setSubjectId(sid);
////        q1.setQuestionNo(qno);
////        q1.setQuestion(ClobProxy.generateProxy(question));
////        q1.setOption1(ClobProxy.generateProxy(option1));
////        q1.setOption2(ClobProxy.generateProxy(option2));
////        q1.setOption3(ClobProxy.generateProxy(option3));
////        q1.setOption4(ClobProxy.generateProxy(option4));
////        q1.setCorrectOption(correct);
////        q1.setMarks(marks);
////        try{
////        System.out.println("Calling save.......................................");
////        sess.save(q1);
////        System.out.println("Calling commit.....................................");
////        tx.commit();
////        }
////        catch(Exception ex)
////        {
////            ex.printStackTrace();
////        }
////        sess.close();
////        sf.close();
//        QuestionsDAO qd=new QuestionsDAOImpl();
//        List<Integer> examids=qd.getAllExamId();
//        for(Integer i:examids)
//        {
//            System.out.println(""+i);
//        }
//        List<Questions> getQst=qd.getQuestionsByExam(133);
//        Iterator<Questions> it=getQst.iterator();
//        List<Questions> updated=new ArrayList<>();
//        Clob clob=null;
//        StringBuffer question=null;
//        StringBuffer option1=null;
//        StringBuffer option2=null;
//        StringBuffer option3=null;
//        StringBuffer option4=null;
//        int q,o1,o2,o3,o4;
//        try{
//        while(it.hasNext())
//        {
//            Questions qt=it.next();
//           clob=qt.getQuestion();
//           Reader questionStream=clob.getCharacterStream();
//           question=new StringBuffer();
//           while((q=questionStream.read())!=-1)
//           {
//               question.append(""+(char)q);
//           }
//           clob=qt.getOption1();
//           Reader option1Stream=clob.getCharacterStream();
//           option1=new StringBuffer();
//           while((o1=option1Stream.read())!=-1)
//           {
//               option1.append(""+(char)o1);
//           }
//           clob=qt.getOption2();
//           Reader option2Stream=clob.getCharacterStream();
//           option2=new StringBuffer();
//           while((o2=option2Stream.read())!=-1)
//           {
//               option2.append(""+(char)o2);
//           }
//           clob=qt.getOption3();
//           Reader option3Stream=clob.getCharacterStream();
//           option3=new StringBuffer();
//           while((o3=option3Stream.read())!=-1)
//           {
//               option3.append(""+(char)o3);
//           }
//           clob=qt.getOption4();
//           Reader option4Stream=clob.getCharacterStream();
//           option4=new StringBuffer();
//           while((o4=option4Stream.read())!=-1)
//           {
//               option4.append(""+(char)o4);
//           }
//            System.out.println(qt.getSno()+","+qt.getExamId()+","+qt.getSubjectId()+","+qt.getQuestionNo()+","+question.toString()+","+option1.toString()+","+option2.toString()+","+option3.toString()+","+option4.toString()+","+qt.getCorrectOption());
//            qt.setCorrectOption("OPTION4");
//            System.out.println(qt.getSno()+","+qt.getExamId()+","+qt.getSubjectId()+","+qt.getQuestionNo()+","+question.toString()+","+option1.toString()+","+option2.toString()+","+option3.toString()+","+option4.toString()+","+qt.getCorrectOption());
//            
//            updated.add(qt);
//        }
//        qd.updateQuestions(updated);
//        }
//        catch(IOException io)
//        {
//            io.printStackTrace();
//        }
//        catch(SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//      
//    }
//
//   
//}
//
