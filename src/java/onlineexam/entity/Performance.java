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
@Table(name="PERFORMANCE")
public class Performance {
    @Id
    @Column(name="sno")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="perf_sno_generator")
    @SequenceGenerator(name="perf_sno_generator",sequenceName="perf_sno_seq_generator",allocationSize=1)
    private int sno;
    @Column(name="user_id")
    private String userId;
    @Column(name="exam_id")
    private int examId;
    @Column(name="subject_id")
    private String subjectId;
    @Column(name="right")
    private int right;
    @Column(name="wrong")
    private int wrong;
    @Column(name="unattempted")
    private int unattempted;
    @Column(name="marks_obtained")
    private double marksObtained;
    @Column(name="percentage")
    private double percentage;
    @Column(name="total_marks")
    private int totalMarks;
    
    public Performance(){}

    public Performance(String userId, int examId, String subjectId, int right, int wrong, int unattempted, double marksObtained, double percentage, int totalMarks) {
        this.sno = sno;
        this.userId = userId;
        this.examId = examId;
        this.subjectId = subjectId;
        this.right = right;
        this.wrong = wrong;
        this.unattempted = unattempted;
        this.marksObtained = marksObtained;
        this.percentage = percentage;
        this.totalMarks = totalMarks;
    }

    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getUnattempted() {
        return unattempted;
    }

    public void setUnattempted(int unattempted) {
        this.unattempted = unattempted;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Performance{" + "sno=" + sno + ", userId=" + userId + ", examId=" + examId + ", subjectId=" + subjectId + ", right=" + right + ", wrong=" + wrong + ", unattempted=" + unattempted + ", marksObtained=" + marksObtained + ", percentage=" + percentage + ", totalMarks=" + totalMarks + '}';
    }
    
}
