package main.java.service;

import main.java.model.Record;

import java.util.Comparator;
import java.util.List;

public class Printer {
    private List<Record> records;

    public void printSortedRecords(List<Record> records, Comparator<Record> byPhoneComparator) {
        this.records = records;
        records.sort(byPhoneComparator);
        for (Record record : records) {
            System.out.println(record.getFullRecord());
        }
        System.out.println();
    }

    public void validationMessage() {
        System.out.println("Validations:");
        for (int i = 0; i < records.size(); i++) {
            if (!records.get(i).isCorrectPhone() || !records.get(i).isCorrectSeparator()) {
                System.out.print("Line" + (i + 1) + ": ");
            }

            if (!records.get(i).isCorrectPhone()) {
                System.out.print("Phone number should be with 9 digits. ");
            }

            if (!records.get(i).isCorrectSeparator()) {
                System.out.print("The separator should be `:` or `-`. ");
            }

            System.out.println();
        }
    }

}
