/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.util.Iterator;
import java.util.List;
import onlineexam.entity.LoginUser;
import onlineexam.entity.Users;
import onlineexam.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class UsersDAOImpl implements UsersDAO{

    @Override
    public Users validateUser(LoginUser user) throws Exception {
        System.out.println("");
        System.out.println("user details in validateUser()"+user);
        Session sess=null;
        try
        {
        sess=HibernateUtils.getSessionFactory().openSession();
            System.out.println("Session opened");
            Transaction tx=sess.beginTransaction();
        System.out.println("user details in validateUser()"+user);
        Query qry=sess.createQuery("from Users e where e.userId=:uid and e.password=:pwd and e.userType=:utp");
        qry.setParameter("uid", user.getUserId());
        qry.setParameter("pwd", user.getPassword());
        qry.setParameter("utp",user.getUserType());
        List<Users> list=qry.list();
        Iterator<Users> it=list.iterator();
        while(it.hasNext())
        {
            Users result=it.next();
            tx.commit();
            sess.close();
            return result;
        }
        }
        catch(Exception ex)
        {
            System.out.println("Exception from UserDAOImple Class");
            ex.printStackTrace();
            if(sess!=null)
            {
                 sess.close();
            }
            throw new Exception();
        }
        return null;
    }

   public  boolean searchUser(String userid)
    {
        SessionFactory sf=HibernateUtils.getSessionFactory();
        Session sess=sf.openSession();
        Users user=sess.get(Users.class, userid);
        if(user!=null)
        {
            sess.close();
            return true;
        }
        sess.close();
        return false;
    }
   
     @Override
    public boolean removeUser(String userId) {
        SessionFactory sf=HibernateUtils.getSessionFactory();
        Session sess=sf.openSession();
        Users user=sess.get(Users.class, userId);
        if(user==null)
        {
            sess.close();
            return false;
        }
        Transaction tx=sess.beginTransaction();
        try{
//        tx=sess.beginTransaction();
        sess.delete(user);
        tx.commit();
        sess.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            if(tx!=null)
            {
                tx.rollback();
            }
            return false;
        }
        sess.close();
        return true;
    }

    @Override
    public boolean registerUser(LoginUser newuser) throws Exception {
        Session sess=HibernateUtils.getSessionFactory().openSession();
        Transaction tx=null;
        try{
        tx=sess.beginTransaction();
        Users u=new Users();
        u.setUserId(newuser.getUserId());
        u.setPassword(newuser.getPassword());
        u.setUserType(newuser.getUserType());
        sess.save(u);
        tx.commit();
        return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            if(tx!=null)
            {
                tx.rollback();
            }
        }
        sess.close();
        return false;
    }

    @Override
    public boolean changePassword(LoginUser user) {
        Session sess=HibernateUtils.getSessionFactory().openSession();
        Transaction tx=sess.beginTransaction();
        NativeQuery qry=sess.createNativeQuery("update users set password=:pwd where user_id=:uid");
        qry.setParameter("pwd", user.getPassword());
        qry.setParameter("uid",user.getUserId());
        boolean res=qry.executeUpdate()==1;
        tx.commit();
        sess.close();
        
        return res;
    }

  
    
}
