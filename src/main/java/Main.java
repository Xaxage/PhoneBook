package main.java;

import main.java.model.Record;
import main.java.service.Comparators;
import main.java.service.Printer;
import main.java.service.RecordInfoExtractor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        RecordInfoExtractor recordInfoExtractor = new RecordInfoExtractor();
        Printer printer = new Printer();
        Comparators comparators = new Comparators();

        String path = recordInfoExtractor.validateFilePath();
        List<String> recordsStringList = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                br.lines().forEach(recordsStringList::add);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Record> records = recordInfoExtractor.extractRecords(recordsStringList);

        printer.printSortedRecords(records, comparators.byFirstNameComparatorDescending());
        printer.validationMessage();
    }
}
