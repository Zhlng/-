package com.example.genealogv.entity;
//成员表
public class Personnel {

    private int PersonnelId;
    private int FamilyId;
    private String PersonnelName;
    private String PersonnelSex;
    private String PersonnelBrithdate;
    private String PersonnelDeathdate;

    public int getPersonnelId() {
        return PersonnelId;
    }

    public void setPersonnelId(int personnelId) {
        PersonnelId = personnelId;
    }

    public int getFamilyId() {
        return FamilyId;
    }

    public void setFamilyId(int familyId) {
        FamilyId = familyId;
    }

    public String getPersonnelName() {
        return PersonnelName;
    }

    public void setPersonnelName(String personnelName) {
        PersonnelName = personnelName;
    }

    public String getPersonnelSex() {
        return PersonnelSex;
    }

    public void setPersonnelSex(String personnelSex) {
        PersonnelSex = personnelSex;
    }

    public String getPersonnelBrithdate() {
        return PersonnelBrithdate;
    }

    public void setPersonnelBrithdate(String personnelBrithdate) {
        PersonnelBrithdate = personnelBrithdate;
    }

    public String getPersonnelDeathdate() {
        return PersonnelDeathdate;
    }

    public void setPersonnelDeathdate(String personnelDeathdate) {
        PersonnelDeathdate = personnelDeathdate;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "PersonnelId=" + PersonnelId +
                ", FamilyId=" + FamilyId +
                ", PersonnelName='" + PersonnelName + '\'' +
                ", PersonnelSex='" + PersonnelSex + '\'' +
                ", PersonnelBrithdate='" + PersonnelBrithdate + '\'' +
                ", PersonnelDeathdate='" + PersonnelDeathdate + '\'' +
                '}';
    }
}
