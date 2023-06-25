package com.example.genealogv.entity;
//关系表
public class Relation {
   private int PersonnelId1;
   private int PersonnelId2;
   private String RelationType;

    public int getPersonnelId1() {
        return PersonnelId1;
    }

    public void setPersonnelId1(int personnelId1) {
        PersonnelId1 = personnelId1;
    }

    public int getPersonnelId2() {
        return PersonnelId2;
    }

    public void setPersonnelId2(int personnelId2) {
        PersonnelId2 = personnelId2;
    }

    public String getRelationType() {
        return RelationType;
    }

    public void setRelationType(String relationType) {
        RelationType = relationType;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "PersonnelId1=" + PersonnelId1 +
                ", PersonnelId2=" + PersonnelId2 +
                ", RelationType='" + RelationType + '\'' +
                '}';
    }
}
