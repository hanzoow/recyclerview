package com.example.recycleview.models;

public class Person {

    private String name;
    private String surname;
    private String preperence;// how people go

    public Person(String name, String surname, String preperence) {
        this.name = name;
        this.surname = surname;
        this.preperence = preperence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPreperence() {
        return preperence;
    }

    public void setPreperence(String preperence) {
        this.preperence = preperence;
    }
}
