/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.entity;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public class Exam {
    int examId;
    String subjectId;
    int totalQuestions;
    int totalMarks;

    public Exam(){}
    
    public Exam(int examId, String subjectId, int totalQuestions, int totalMarks) {
        this.examId = examId;
        this.subjectId = subjectId;
        this.totalQuestions = totalQuestions;
        this.totalMarks = totalMarks;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "Exam{" + "examId=" + examId + ", subjectId=" + subjectId + ", totalQuestions=" + totalQuestions + ", totalMarks=" + totalMarks + '}';
    }
    
    
}
