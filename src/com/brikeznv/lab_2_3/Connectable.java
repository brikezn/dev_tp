package com.brikeznv.lab_2_3;

/**
 * Created by Y70-70 on 02.06.2017.
 */
public interface Connectable {

    public void connect(String ip);

    public void disconnect();

    public String getIp();
}
