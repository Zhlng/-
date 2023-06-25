package com.example.genealogv.entity;
//成员表
public class Personnel {
    private int Personnel_id;
    private String Personnel_name;
    private String Personnel_sex;
    private String Personnel_birthdate;
    private String Personnel_deathdate;
    private int Family_id;

    public String getPersonnel_name() {
        return Personnel_name;
    }

    public void setPersonnel_name(String personnel_name) {
        Personnel_name = personnel_name;
    }

    public int getFamily_id() {
        return Family_id;
    }

    public void setFamily_id(int family_id) {
        Family_id = family_id;
    }

    public String getPersonnel_deathdate() {
        return Personnel_deathdate;
    }

    public void setPersonnel_deathdate(String personnel_deathdate) {
        Personnel_deathdate = personnel_deathdate;
    }

    public String getPersonnel_birthdate() {
        return Personnel_birthdate;
    }

    public void setPersonnel_birthdate(String personnel_birthdate) {
        Personnel_birthdate = personnel_birthdate;
    }

    public String getPersonnel_sex() {
        return Personnel_sex;
    }

    public void setPersonnel_sex(String personnel_sex) {
        Personnel_sex = personnel_sex;
    }

    public int getPersonnel_id() {
        return Personnel_id;
    }

    public void setPersonnel_id(int personnel_id) {
        Personnel_id = personnel_id;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "Personnel_id=" + Personnel_id +
                ", Personnel_name='" + Personnel_name + '\'' +
                ", Personnel_sex='" + Personnel_sex + '\'' +
                ", Personnel_birthdate='" + Personnel_birthdate + '\'' +
                ", Personnel_deathdate='" + Personnel_deathdate + '\'' +
                ", Family_id=" + Family_id +
                '}';
    }
}
