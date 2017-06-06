package com.brikeznv.lab_4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Y70-70 on 06.06.2017.
 */
public class ConsoleWindow {

    private List<Document> documents;
    private Scanner sc;

    public ConsoleWindow() {
        sc = new Scanner(System.in);
        documents = new LinkedList<>();
    }

    public void start() {
        documents.add(new Passport("Иванов", "Алекандр", "4008", "645448"));
        documents.add(new Passport("Дмитрий", "Шевчук", "4002", "119573"));
        documents.add(new Passport("Анастасия", "Дарер", "4011", "625631"));
        documents.add(new Passport("Владислав", "Карев", "4007", "844404"));
        documents.add(new StudentId("Иванов", "Алекандр", "СПб ГУТ", "948371"));
        documents.add(new StudentId("Дмитрий", "Шевчук", "ИТМО", "837461"));
        documents.add(new StudentId("Валерий", "Рябцев", "СПб ГУТ", "113321"));
        documents.add(new StudentId("Виктория", "Шестакова", "ЛЭТИ", "648631"));
        print();

        while (true) {
            String line = sc.nextLine();

            try {
                parseAndPerform(line);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect number of arguments, please try again!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Notebook does not exists!");
            } catch (Exception e) {
                System.err.println("Unknown error.");
            }
        }
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

            case "set":
                set(commands[1], commands[2], commands[3], commands[4], commands[5]);
                break;

            case "count":
                count(commands[1]);
                break;

            case "help":
                printHelp();
                break;

            case "h":
                printHelp();
                break;
            default:
                System.out.println("Incorrect line. Please try again.");
        }
    }

    private void count(String surname) {
        int i = 0;

        for (Document document : documents) {
            if (document.getSurname().equals(surname)) {
                i++;
            }
        }

        System.out.println("Количество докуметнов у человека с фамилией " + surname + " равно " + i);
    }

    private void set(String idString, String name, String surname, String param1, String param2) {
        int id = Integer.parseInt(idString) - 1;
        Document document = documents.get(id);
        document.setName(name);
        document.setSurname(surname);

        if (document.getClass().equals(Passport.class)) {
            Passport passport = (Passport) document;
            passport.setSeries(param1);
            passport.setNumber(param2);
        } else {
            StudentId studentId = (StudentId) document;
            studentId.setUniversity(param1);
            studentId.setId(param2);
        }
    }

    private void print() {

        int maxNameLength = "Имя".length();
        int maxSurnameLength = "Фамилия".length();
        int maxFirstParamLength = "Университет".length();
        int maxSecondParamLength = "Номер".length();

        for (Document document : documents) {
            int nameLength = document.getName().length();
            int surnameLength = document.getSurname().length();
            maxNameLength = nameLength > maxNameLength ? nameLength : maxNameLength;
            maxSurnameLength = surnameLength > maxSurnameLength ? surnameLength : maxSurnameLength;

            if (document.getClass().equals(Passport.class)) {
                Passport passport = (Passport) document;
                int firstParamLenght = passport.getSeries().length();
                int secondParamLength = passport.getNumber().length();
                maxFirstParamLength = firstParamLenght > maxFirstParamLength ?
                        firstParamLenght : maxFirstParamLength;
                maxSecondParamLength = secondParamLength > maxSecondParamLength ?
                        secondParamLength : maxSecondParamLength;
            } else {
                StudentId studentId = (StudentId) document;
                int firstParamLenght = studentId.getUniversity().length();
                int secondParamLength = studentId.getId().length();
                maxFirstParamLength = firstParamLenght > maxFirstParamLength ?
                        firstParamLenght : maxFirstParamLength;
                maxSecondParamLength = secondParamLength > maxSecondParamLength ?
                        secondParamLength : maxSecondParamLength;
            }
        }

        StringBuilder passportBuilder = new StringBuilder();
        passportBuilder.append("#   ");
        passportBuilder.append("Имя");
        addTabulation(passportBuilder, maxNameLength, "Имя".length());
        passportBuilder.append("Фамилия");
        addTabulation(passportBuilder, maxSurnameLength, "Фамилия".length());
        passportBuilder.append("Серия");
        addTabulation(passportBuilder, maxFirstParamLength, "Серия".length());
        passportBuilder.append("Номер");
        addTabulation(passportBuilder, maxSecondParamLength, "Номер".length());
        passportBuilder.append("\n");

        StringBuilder studentIdBuilder = new StringBuilder();
        studentIdBuilder.append("#   ");
        studentIdBuilder.append("Имя");
        addTabulation(studentIdBuilder, maxNameLength, "Имя".length());
        studentIdBuilder.append("Фамилия");
        addTabulation(studentIdBuilder, maxSurnameLength, "Фамилия".length());
        studentIdBuilder.append("Университет");
        addTabulation(studentIdBuilder, maxFirstParamLength, "Университет".length());
        studentIdBuilder.append("Номер");
        addTabulation(studentIdBuilder, maxSecondParamLength, "Номер".length());
        studentIdBuilder.append("\n");

        int i = 1;
        int j = 1;

        for (Document document : documents) {
            if (document.getClass().equals(Passport.class)) {
                Passport passport = (Passport) document;
                String name = passport.getName();
                String surname = passport.getSurname();
                String firstParam = passport.getSeries();
                String secondParam = passport.getNumber();
                passportBuilder.append(i++ + ".  ");

                passportBuilder.append(name);
                addTabulation(passportBuilder, maxNameLength, name.length());
                passportBuilder.append(surname);
                addTabulation(passportBuilder, maxSurnameLength, surname.length());
                passportBuilder.append(firstParam);
                addTabulation(passportBuilder, maxFirstParamLength, firstParam.length());
                passportBuilder.append(secondParam);
                addTabulation(passportBuilder, maxSecondParamLength, secondParam.length());
                passportBuilder.append("\n");

            } else {
                StudentId studentId = (StudentId) document;
                String name = studentId.getName();
                String surname = studentId.getSurname();
                String firstParam = studentId.getUniversity();
                String secondParam = studentId.getId();
                studentIdBuilder.append(i++ + ".  ");

                studentIdBuilder.append(name);
                addTabulation(studentIdBuilder, maxNameLength, name.length());
                studentIdBuilder.append(surname);
                addTabulation(studentIdBuilder, maxSurnameLength, surname.length());
                studentIdBuilder.append(firstParam);
                addTabulation(studentIdBuilder, maxFirstParamLength, firstParam.length());
                studentIdBuilder.append(secondParam);
                addTabulation(studentIdBuilder, maxSecondParamLength, secondParam.length());
                studentIdBuilder.append("\n");
            }
        }

        System.out.println("Пасспорт\n" + passportBuilder.toString() +
                "\nСтуденческий билет\n" + studentIdBuilder.toString());
    }

    private void addTabulation(StringBuilder builder, int maxValue, int currentValue) {

        for (int i = -2; i < maxValue - currentValue; i++) {
            builder.append(" ");
        }
    }

    private void exit() {
        System.exit(1);
    }

    private void printHelp(){
        String helpString = "" +
                "1. EXIT - закрыть консоль.\n" +
                "2. PRINT - вывести список всех записей.\n" +
                "3. SET id param_x4 - изменить данные записи. \n" +
                "4. COUNT surname - вчисление количества документов по заданной фамилии.\n" +
                "5. HELP (H) - ввод списка доспупных комманд. \n";
        System.out.println(helpString);
    }
}