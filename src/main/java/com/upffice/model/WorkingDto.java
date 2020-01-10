package com.upffice.model;

import javax.persistence.*;

@Entity
@Table(name = "working")
@IdClass(WorkingDtoPK.class)
public class WorkingDto {
    @Id
    @Column(name = "emp_id")
    private int empId;

    @Id
    @Column(name = "working_date")
    private String workingDate;

    @Column(name = "working_in")
    private int workingIn;

    @Column(name = "working_out")
    private boolean workingOut;

    @Column(name = "working_time")
    private boolean workingTime;

}
