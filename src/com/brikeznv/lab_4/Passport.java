package com.brikeznv.lab_4;

/**
 * Created by Y70-70 on 06.06.2017.
 */
public class Passport extends Document {
    protected String series;
    protected String number;

    public Passport() {

    }

    public Passport(String name, String surname, String series, String number) {
        super(name, surname);
        this.series = series;
        this.number = number;
    }

    public String toString() {
        return super.name + " " + super.surname + " " + series + " " + number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
