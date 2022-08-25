/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.util.ArrayList;
import java.util.List;
import onlineexam.entity.Exam;
import onlineexam.entity.Subjects;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public interface ExamDAO {
public abstract Exam getExamDetails();
public abstract ArrayList<Subjects> getSubjectDetails();
public abstract String getSubjectByExamId(int examId);
public abstract void setExam(Exam e);
public void commitExam();
}
