package com.example.genealogv.entity;
//事件表
public class Inccident {
    private String Inccider_date;
    private String Inccider_type;
    private String Inccider_description;
    private String Inccider_attachments;
    private int Personnel_id;


    public int getPersonnel_id() {
        return Personnel_id;
    }

    public void setPersonnel_id(int personnel_id) {
        Personnel_id = personnel_id;
    }

    public String getInccider_attachments() {
        return Inccider_attachments;
    }

    public void setInccider_attachments(String inccider_attachments) {
        Inccider_attachments = inccider_attachments;
    }

    public String getInccider_description() {
        return Inccider_description;
    }

    public void setInccider_description(String inccider_description) {
        Inccider_description = inccider_description;
    }

    public String getInccider_type() {
        return Inccider_type;
    }

    public void setInccider_type(String inccider_type) {
        Inccider_type = inccider_type;
    }

    public String getInccider_date() {
        return Inccider_date;
    }

    public void setInccider_date(String inccider_date) {
        Inccider_date = inccider_date;
    }
    @Override
    public String toString() {
        return "Inccident{" +
                "Inccider_date='" + Inccider_date + '\'' +
                ", Inccider_type='" + Inccider_type + '\'' +
                ", Inccider_description='" + Inccider_description + '\'' +
                ", Inccider_attachments='" + Inccider_attachments + '\'' +
                ", Personnel_id=" + Personnel_id +
                '}';
    }
}
