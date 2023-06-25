package com.example.genealogv.entity;
//家族表
public class Family {
    private int Family_id;
    private int User_id;
    private String Family_name;
    private String Family_intro;
    private String Family_date;

    public String getFamily_date() {
        return Family_date;
    }

    public void setFamily_date(String family_date) {
        Family_date = family_date;
    }

    public String getFamily_intro() {
        return Family_intro;
    }

    public void setFamily_intro(String family_intro) {
        Family_intro = family_intro;
    }

    public String getFamily_name() {
        return Family_name;
    }

    public void setFamily_name(String family_name) {
        Family_name = family_name;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getFamily_id() {
        return Family_id;
    }

    public void setFamily_id(int family_id) {
        Family_id = family_id;
    }

    @Override
    public String toString() {
        return "Family{" +
                "Family_id=" + Family_id +
                ", User_id=" + User_id +
                ", Family_name='" + Family_name + '\'' +
                ", Family_intro='" + Family_intro + '\'' +
                ", Family_date='" + Family_date + '\'' +
                '}';
    }
}
//alt+insert快速导入方法