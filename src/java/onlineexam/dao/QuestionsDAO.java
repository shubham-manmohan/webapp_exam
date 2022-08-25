/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.util.ArrayList;
import java.util.List;
import onlineexam.entity.GetExamId;
import onlineexam.entity.Questions;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public interface QuestionsDAO {
public abstract boolean addQuestionsList(ArrayList<Questions> questionList);
public abstract List<Questions> getQuestionsByExam(int examId);
public abstract boolean updateQuestions(List<Questions> questionList);
public abstract List<GetExamId> getAllExamId();
public abstract ArrayList<GetExamId> getExamIdForStudent(String userId);
public List<Questions> getQuestionsForStudentByExamId(int examId);
}
