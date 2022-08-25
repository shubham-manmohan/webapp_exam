/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.util.List;
import onlineexam.entity.Performance;
import onlineexam.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class PerformanceDAOImpl implements PerformanceDAO {

    @Override
    public boolean addPerformance(Performance pr) {
        boolean result=true;
        try
        {
        Session sess=HibernateUtils.getSessionFactory().openSession();
        Transaction tx=sess.beginTransaction();
        sess.save(pr);
        tx.commit();
        sess.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            result=false;
        }
        return result;
    }

    @Override
    public List<Performance> getPerformance(String userId) {
        try{
       Session sess=HibernateUtils.getSessionFactory().openSession();
       Query<Performance> qry=sess.createQuery("from Performance where userId=:uid",Performance.class);
       qry.setParameter("uid", userId);
       List<Performance> list=qry.list();
       sess.close();
       return list;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Performance> getAllPerformance() {
       Session sess=HibernateUtils.getSessionFactory().openSession();
        try{
       
       Query<Performance> qry=sess.createQuery("from Performance",Performance.class);
       List<Performance> list=qry.list();
       return list;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
         finally
         {
            if(sess!=null)
                sess.close();
         }
        return null;
    }
    
    
}
