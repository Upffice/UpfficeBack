package com.upffice.model;

import java.io.Serializable;
import java.sql.Date;

//Annual 테이블의 기본키를 정의하는 클래스
public class AnnualDtoPK implements Serializable {
    private int empId;
    private String annualDate;
}
