package com.db;

import java.util.Date;

/**
 * Created by Raluca on 11.03.2017.
 */
public class Student {
    private int id;
    private String name;
    private Date birth;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String nume) {
        this.name = nume;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;}

    public Date getBirth() {
        return birth;
    }
    public void setBirth(String brth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", birth=" + birth
                + ", address=" + address + "]";
    }
}
