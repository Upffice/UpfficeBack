package com.upffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentDto {
    /*
     * Department 테이블에 해당하는 Dto
     */

    @Id
    @Column(name = "dep_id")
    private int dep_id;

    @Column(name = "dep_name")
    private String dep_name;

    public DepartmentDto() {
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                '}';
    }
}
