package com.brikeznv.lab_2_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Y70-70 on 06.06.2017.
 */
public class ConsoleWindow {

    private List<ConnectableNotebook> notebooks;
    private Scanner sc;

    public ConsoleWindow() {
        sc = new Scanner(System.in);
        notebooks = new LinkedList<>();
    }

    public void start() {
        test();


        while (true) {
            String line = sc.nextLine();

            try {
                parseAndPerform(line);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect number of arguments, please try again!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Notebook does not exists!");
            }
        }
    }

    private void test() {
        notebooks.add(new ConnectableNotebook("Asus", "NJK901"));
        notebooks.add(new ConnectableNotebook("Lenovo", "Y70-70"));
        notebooks.add(new ConnectableNotebook("Huawei", "P9_lite_forward"));
        print();
    }

    private void parseAndPerform(String line) {

        if(line.compareTo("") == 0) return;

        String[] commands = line.split(" ");

        switch (commands[0]) {
            case "exit":
                exit();
                break;
            case "print":
                print();
                break;

            case "add":
                add(commands[1], commands[2]);
                break;

            case "setpower":
                setPower(commands[1], commands[2]);
                break;

            case "setnetwork":
                setNetwork(commands[1], commands[2]);
                break;

            case "delete":
                delete(commands[1]);
                break;

            case "help":
                printHelp();
                break;
            default:
                System.out.println("Incorrect line. Please try again.");
        }
    }

    private void exit() {
        System.exit(1);
    }

    private void add(String manufacturer, String model) {

        notebooks.add(new ConnectableNotebook(manufacturer, model));
        System.out.println("Value was successfully added.");
    }

    private void setPower(String value, String number) {

        int i = Integer.parseInt(number);
        boolean power = value.equals("on");
        ConnectableNotebook notebook = notebooks.get(--i);
        notebook.setPowerIsOn(power);

        if (!power) {
            notebook.setNetworkIsOn(false);
        }

        System.out.println("Power was set.");
    }

    private void setNetwork(String value, String number) {

        int i = Integer.parseInt(number);
        boolean network = value.equals("on");
        ConnectableNotebook notebook = notebooks.get(--i);

        if (notebook.powerIsOn()) {
            notebook.setNetworkIsOn(network);
            System.out.println("Network successfully set.");
        } else {
            System.out.println("Notebook is off! Can not set network");
        }
    }

    private void delete(String number) {
        int i = Integer.parseInt(number);
        notebooks.remove(--i);
        System.out.println("Deleted successfully!");
    }

    private void printHelp(){
        String helpString = "" +
                "1. EXIT - закрыть консоль.\n" +
                "2. ADD [] - добавить поле.\n" +
                "3. SETPOWER ON/OFF [i] - включить или выключить питание компьютера.\n" +
                "4. SETNETWORK ON/OFF [i] - включить или выключить интернет на компьютере.\n" +
                "5. DELETE [i] - удалить запись.\n" +
                "6. PRINT - вывести список всех записей.\n";
        System.out.println(helpString);
    }

    private void printError(String err) {
        System.err.print(err);
    }

    private void print() {

        int mfColumnMax = "manufacturer".length();
        int modelColumnMax = "model".length();
        int powerColumnMax = 5;
        int networkColumnMax = 7;

        for (ConnectableNotebook notebook : notebooks) {
            final String mf = notebook.getManufacturer();
            final String model = notebook.getModel();
            mfColumnMax = mf.length() > mfColumnMax ? mf.length() : mfColumnMax;
            modelColumnMax = model.length() > modelColumnMax ? model.length() : modelColumnMax;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("#   ");
        builder.append("manufacturer  ");
        for (int j = 0; j <= mfColumnMax - "manufacturer".length(); j++) {
            builder.append(" ");
        }


        builder.append("model  ");

        for (int j = 0; j <= modelColumnMax - "model".length(); j++) {
            builder.append(" ");
        }

        builder.append("power  ");
        builder.append("network");
        builder.append("\n");
        int i = 1;

        for (ConnectableNotebook notebook : notebooks) {
            final String mf = notebook.getManufacturer();
            final String model = notebook.getModel();
            final String power = notebook.powerIsOn() ? "on" : "off";
            final String network = notebook.networkIsOn() ? "on" : "off";

            builder.append(i).append(". ");

            if (i < 10) {
                builder.append(" ");
            }

            builder.append(mf).append("  ");

            for (int j = 0; j <= mfColumnMax - mf.length(); j++) {
                builder.append(" ");
            }

            builder.append(model).append("  ");

            for (int j = 0; j <= modelColumnMax - model.length(); j++) {
                builder.append(" ");
            }

            builder.append(power).append("    ");

            if (power.length() == 2) {
                builder.append(" ");
            }

            builder.append(network);
            builder.append("\n");
            i++;
        }

        System.out.println(builder.toString());
    }
}
