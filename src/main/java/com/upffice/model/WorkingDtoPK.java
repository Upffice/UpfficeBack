package com.upffice.model;

import java.io.Serializable;
import java.sql.Date;

//working 테이블의 기본키를 정의하는 클래스
public class WorkingDtoPK implements Serializable {
    private int empId;
    private Date workingDate;
}
