package com.brikeznv.lab_4;

/**
 * Created by Y70-70 on 06.06.2017.
 */
public class StudentId extends Document {

    protected String university;
    protected String id;

    public StudentId() {

    }

    public StudentId(String name, String surname, String university, String id) {
        super(name, surname);
        this.university = university;
        this.id = id;
    }

    public String toString() {
        return super.name + " " + super.surname + " " + university + " " + id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
