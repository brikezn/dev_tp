package com.brikeznv.lab_2_3;

/**
 * Created by Y70-70 on 02.06.2017.
 */
public class Notebook {

    protected String manufacturer;
    protected String model;
    protected boolean powerIsOn = false;
    protected boolean networkIsOn = false;

    public Notebook() {

    }

    public Notebook(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean powerIsOn() {
        return powerIsOn;
    }

    public void setPowerIsOn (boolean powerIsOn) {
        this.powerIsOn = powerIsOn;
    }

    public boolean networkIsOn() {
        return networkIsOn;
    }

    public void setNetworkIsOn(boolean networkIsOn) {
        this.networkIsOn = networkIsOn;
    }
}
