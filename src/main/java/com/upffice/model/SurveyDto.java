package com.upffice.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="survey")
public class SurveyDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int survey_id;

    @Column(name="survey_writer")
    private String survey_writer;

    @Column(name="survey_subject")
    private String survey_subject;

    @Column(name="survey_detail")
    private String survey_detail;

    @Column(name="survey_question")
    private String survey_question;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "start_date")
    private Timestamp start_date;

    @Column(name = "end_date")
    private Timestamp end_date;

    public SurveyDto(){
    }
    public SurveyDto(String survey_writer,String survey_subject,String survey_detail,String survey_question, String answer1, String answer2, String answer3, Timestamp start_date, Timestamp end_date){
        this.survey_writer=survey_writer;
        this.survey_subject=survey_subject;
        this.survey_detail=survey_detail;
        this.survey_question=survey_question;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.start_date=start_date;
        this.end_date=end_date;
    }

    public SurveyDto(String answer1, String answer2, String answer3) {

    }


    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public String getSurvey_writer() {
        return survey_writer;
    }

    public void setSurvey_writer(String survey_writer) {
        this.survey_writer = survey_writer;
    }

    public String getSurvey_subject() {
        return survey_subject;
    }

    public void setSurvey_subject(String survey_subject) {
        this.survey_subject = survey_subject;
    }

    public String getSurvey_detail() {
        return survey_detail;
    }

    public void setSurvey_detail(String survey_detail) {
        this.survey_detail = survey_detail;
    }

    public String getSurvey_question() {
        return survey_question;
    }

    public void setSurvey_question(String survey_question) {
        this.survey_question = survey_question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "SurveyDto{" +
                "survey_id=" + survey_id +
                ", survey_writer='" + survey_writer + '\'' +
                ", survey_subject='" + survey_subject + '\'' +
                ", survey_detail='" + survey_detail + '\'' +
                ", survey_question='" + survey_question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
