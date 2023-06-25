package com.example.genealogv.entity;
//家族表
public class Family {
    private int FamilyId;
    private int Id;
    private String FamilyName;
    private String FamilyDescription;
    private String FamilyDate;

    public int getFamilyId() {
        return FamilyId;
    }

    public void setFamilyId(int familyId) {
        FamilyId = familyId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getFamilyDescription() {
        return FamilyDescription;
    }

    public void setFamilyDescription(String familyDescription) {
        FamilyDescription = familyDescription;
    }

    public String getFamilyDate() {
        return FamilyDate;
    }

    public void setFamilyDate(String familyDate) {
        FamilyDate = familyDate;
    }

    @Override
    public String toString() {
        return "Family{" +
                "FamilyId=" + FamilyId +
                ", Id=" + Id +
                ", FamilyName='" + FamilyName + '\'' +
                ", FamilyDescription='" + FamilyDescription + '\'' +
                ", FamilyDate='" + FamilyDate + '\'' +
                '}';
    }
}


