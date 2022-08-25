/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class HibernateUtils {
    private static SessionFactory sf=null;
    static
    {
        try
        {
            Configuration cfg=new Configuration();
            cfg.configure("resources/hibernate.cfg.xml");
            sf=cfg.buildSessionFactory();
        }
        catch(ExceptionInInitializerError ex)
        {
            System.out.println("Error in hibernate util");
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Exception in session factory creation"+ex);
        }
    }
    public static SessionFactory getSessionFactory()
    {
        return sf;
    }
    public static void closeSessionFactory()
            {
                if(sf!=null)
                {
                    sf.close();
                }
            }
}
