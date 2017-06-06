package com.brikeznv.lab_2_3;

import java.io.PrintStream;

/**
 * Created by Y70-70 on 02.06.2017.
 */
public class NotebookException extends Exception {

    @Override
    public void printStackTrace(PrintStream s) {

        System.out.println(s);
    }
}
