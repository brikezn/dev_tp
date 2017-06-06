package com.brikeznv.lab_4;

public class Document {

    protected String name;
    protected String surname;

    public Document() {

    }

    public Document(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void printData() {
        System.out.println(toString());
    }


    public String toString() {
        return name + " " + surname;
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
}
