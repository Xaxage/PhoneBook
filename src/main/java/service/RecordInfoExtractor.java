package main.java.service;

import main.java.model.Record;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordInfoExtractor {
    private final Scanner sc;
    private final List<Record> records;
    private final StringBuilder tmpBuilder;

    public RecordInfoExtractor() {
        this.sc = new Scanner(System.in);
        this.records = new ArrayList<>();
        this.tmpBuilder = new StringBuilder();
    }

    public String validateFilePath() {
        System.out.println("Enter file path:");
        String path = sc.nextLine();

        File file = new File(path);
        while (!file.exists()) {
            System.out.println("File path is invalid. Please enter valid path.");
            path = sc.nextLine();
            file = new File(path);
        }
        return path;
    }

    public List<Record> extractRecords(List<String> recordsStringList) {
        String currentLine = "";
        for (String s : recordsStringList) {
            Record record = new Record();
            currentLine = s;


            //checking if separator is valid
            separatorExtractor(currentLine, record);


            //extracting phone number
            phoneExtractor(currentLine, record);


            //extracting full name
            nameExtractor(currentLine, record);

            record.setFullRecord(s);

        }
        return records;
    }

    private void nameExtractor(String currentLine, Record record) {
        char ch = ' ';
        tmpBuilder.delete(0, tmpBuilder.length());
        int spaceCounter = 0;
        for (int j = 0; j < currentLine.length(); j++) {
            ch = currentLine.charAt(j);
            if (Character.isLetter(ch)) {
                tmpBuilder.append(ch);
            } else if (ch == ' ' && spaceCounter != 1) {
                record.setFirstName(String.valueOf(tmpBuilder));
                tmpBuilder.delete(0, tmpBuilder.length());
                spaceCounter++;
            } else {
                record.setLastName(String.valueOf(tmpBuilder));
                tmpBuilder.delete(0, tmpBuilder.length());
                break;
            }

        }
    }

    private void phoneExtractor(String currentLine, Record record) {
        char ch = ' ';
        for (int j = 0; j < 11; j++) {
            ch = currentLine.charAt(currentLine.length() - 1 - j);
            if (Character.isDigit(ch)) {
                tmpBuilder.append(ch);
            } else {
                record.setPhone(String.valueOf(tmpBuilder.reverse()));
                records.add(record);
                break;
            }
        }
    }

    private void separatorExtractor(String currentLine, Record record) {
        if (!(currentLine.contains(":") || currentLine.contains("-"))) {
            record.setCorrectSeparator(false);
        }
    }
}
