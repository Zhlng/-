package com.example.genealogv.entity;
//事件表
public class Inccident {
    private int PersonnelId;
    private String InccidentDate;
    private String InccidentDescription;
    private String InccidentType;
    private String InccidentAttachments;

    public int getPersonnelId() {
        return PersonnelId;
    }

    public void setPersonnelId(int personnelId) {
        PersonnelId = personnelId;
    }

    public String getInccidentDate() {
        return InccidentDate;
    }

    public void setInccidentDate(String inccidentDate) {
        InccidentDate = inccidentDate;
    }

    public String getInccidentDescription() {
        return InccidentDescription;
    }

    public void setInccidentDescription(String inccidentDescription) {
        InccidentDescription = inccidentDescription;
    }

    public String getInccidentType() {
        return InccidentType;
    }

    public void setInccidentType(String inccidentType) {
        InccidentType = inccidentType;
    }

    public String getInccidentAttachments() {
        return InccidentAttachments;
    }

    public void setInccidentAttachments(String inccidentAttachments) {
        InccidentAttachments = inccidentAttachments;
    }

    @Override
    public String toString() {
        return "Inccident{" +
                "PersonnelId=" + PersonnelId +
                ", InccidentDate='" + InccidentDate + '\'' +
                ", InccidentDescription='" + InccidentDescription + '\'' +
                ", InccidentType='" + InccidentType + '\'' +
                ", InccidentAttachments='" + InccidentAttachments + '\'' +
                '}';
    }
}