/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
@Entity
@Table(name="QUESTIONS")
public class Questions {
    @Id
    @Column(name="sno")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sno_generator")
    @SequenceGenerator(name="sno_generator",sequenceName="sno_seq_generator",allocationSize=1)
    private int sno;
    @Column(name="exam_id")
    private int examId;
    @Column(name="subject_id")
    private String subjectId;
    @Column(name="question_no")
    private int questionNo;
    
    @Column(name="question")
    private String question;
    
    @Column(name="option1")
    private String option1;
    
    @Column(name="option2")
    private String option2;
    
    @Column(name="option3")
    private String option3;
    
    @Column(name="option4")
    private String option4;
    @Column(name="correct_option")
    private String correctOption;
    @Column(name="marks")
    private int marks;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
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

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Questions{" + "sno=" + sno + ", examId=" + examId + ", subjectId=" + subjectId + ", questionNo=" + questionNo + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctOption=" + correctOption + ", marks=" + marks + '}';
    }
   
}
