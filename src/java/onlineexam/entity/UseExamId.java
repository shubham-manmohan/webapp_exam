/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.entity;

import java.util.List;
import onlineexam.dao.PerformanceDAO;
import onlineexam.dao.PerformanceDAOImpl;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class UseExamId {
    public static void main(String[] args) {
        try{
        PerformanceDAO qdo=new PerformanceDAOImpl();
        List<Performance> list=qdo.getPerformance("7009");
        for(Performance pr:list)
        {
            System.out.println(pr.toString());
        }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
//        ExamDAO edo=new ExamDAOImpl();
//        System.out.println("Subject is "+edo.getSubjectByExamId(17));
    }
}
