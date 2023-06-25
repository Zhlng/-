package com.example.genealogv.entity;
//关系表
public class Relation {
    private int Personnel_id1;
    private int Personnel_id2;
    private String Personnel_type;
    public int getPersonnel_id1() {
        return Personnel_id1;
    }

    public void setPersonnel_id1(int personnel_id1) {
        Personnel_id1 = personnel_id1;
    }

    public int getPersonnel_id2() {
        return Personnel_id2;
    }

    public void setPersonnel_id2(int personnel_id2) {
        Personnel_id2 = personnel_id2;
    }

    public String getPersonnel_type() {
        return Personnel_type;
    }

    public void setPersonnel_type(String personnel_type) {
        Personnel_type = personnel_type;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "Personnel_id1=" + Personnel_id1 +
                ", Personnel_id2=" + Personnel_id2 +
                ", Personnel_type='" + Personnel_type + '\'' +
                '}';
    }
}
