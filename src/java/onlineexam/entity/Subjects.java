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
public class Subjects {
String subjectId;
String subjectName;
   public Subjects(){}
   
    public Subjects(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subjects{" + "subjectId=" + subjectId + ", subjectName=" + subjectName + '}';
    }
    
    
}
