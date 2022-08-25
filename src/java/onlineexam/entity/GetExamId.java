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
public class GetExamId {
    private int examId;
    private String subjectId;

    public GetExamId(int examId, String subjectId) {
        this.examId = examId;
        this.subjectId = subjectId;
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

   

    @Override
    public String toString() {
        return "GetExamId{" + "examId=" + examId + ", subjectId=" + subjectId + '}';
    }
    
}
