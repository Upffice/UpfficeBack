package com.upffice.model;

import javax.persistence.*;
@Entity
@Table(name = "board")
@IdClass(BoardDtoPK.class)
public class BoardDto {

    @Id
    @Column(name = "board_name")
    private String board_name;

    @Id
    @Column(name = "dep_id")
    private int dep_id;

    public BoardDto() {
    }
    public BoardDto(String board_name,int dep_id) {
        this.board_name=board_name;
        this.dep_id=dep_id;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "board_name='" + board_name + '\'' +
                ", dep_id=" + dep_id +
                '}';
    }
}
