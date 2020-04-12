package com.jibinjames.SpringDataJpa.Models;


import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "StudentId")
    private  Long sid;

    @Column(name = "StudentName")
    private String name;

    @Column(name = "Place")
    private String place;

    private String address;
    private int rank;


    public Student(Long sid, String name, String place, String address, int rank) {
        this.sid = sid;
        this.name = name;
        this.place = place;
        this.address = address;
        this.rank = rank;
    }


    public  Student()
    {

    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", address='" + address + '\'' +
                ", rank=" + rank +
                '}';
    }

}
