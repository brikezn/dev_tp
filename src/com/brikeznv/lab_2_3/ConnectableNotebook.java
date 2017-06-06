package com.brikeznv.lab_2_3;

/**
 * Created by Y70-70 on 04.06.2017.
 */
public class ConnectableNotebook extends Notebook implements Connectable {

    private String ip;

    public ConnectableNotebook() {
        super();
    }

    public ConnectableNotebook(String manufacturer, String model) {
        super(manufacturer, model);
    }



    @Override
    public void connect(String ip) {
        this.ip = ip;
    }

    @Override
    public void disconnect() {
        ip = null;
    }

    @Override
    public String getIp() {
        return ip;
    }
}
