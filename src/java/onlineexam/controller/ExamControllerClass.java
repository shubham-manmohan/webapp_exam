/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.controller;

import onlineexam.dao.ExamDAO;
import onlineexam.entity.Exam;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class ExamControllerClass {
    private static Exam e=null;
    private static ExamDAO exam=null;

    public static Exam getE() {
        return e;
    }

    public static void setE(Exam e) {
        ExamControllerClass.e = e;
    }

    public static ExamDAO getExam() {
        return exam;
    }

    public static void setExam(ExamDAO exam) {
        ExamControllerClass.exam = exam;
    }
    
}
