package com.upffice.model;

import javax.persistence.*;

@Entity
@Table(name = "surveyparticipants")
@IdClass(ParticipantsDtoPK.class)
public class ParticipantsDto {
    @Id
    @Column(name="survey_id")
    private int survey_id;

    @Id
    @Column(name="emp_id")
    private int emp_id;

    @Column(name = "selection")
    private int selection;

    public ParticipantsDto() {
    }
    public ParticipantsDto(int survey_id,int emp_id, int selection) {
        this.survey_id=survey_id;
        this.emp_id=emp_id;
        this.selection=selection;
    }
    public ParticipantsDto(int selection) {
        this.selection=selection;
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    @Override
    public String toString() {
        return "ParticipantsDto{" +
                "survey_id=" + survey_id +
                ", emp_id=" + emp_id +
                ", selection=" + selection +
                '}';
    }
}
