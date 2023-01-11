package main.java.service;

import main.java.model.Record;

import java.util.Comparator;

public class Comparators {

    public Comparator<Record> byPhoneComparatorDescending() {
        return (Record o1, Record o2) -> (o2.getPhone().substring(0, 3).compareTo(o1.getPhone().substring(0, 3)));
    }

    public Comparator<Record> byPhoneComparatorAscending() {
        return (Record o1, Record o2) -> (o1.getPhone().substring(0, 3).compareTo(o2.getPhone().substring(0, 3)));
    }

    public Comparator<Record> byFirstNameComparatorAscending() {
        return (Record o1, Record o2) -> (o1.getFirstName().compareTo(o2.getFirstName()));
    }

    public Comparator<Record> byFirstNameComparatorDescending() {
        return (Record o1, Record o2) -> (o2.getFirstName().compareTo(o1.getFirstName()));
    }

    public Comparator<Record> byLastNameComparatorAscending() {
        return (Record o1, Record o2) -> (o1.getLastName().compareTo(o2.getLastName()));
    }

    public Comparator<Record> byLastNameComparatorDescending() {
        return (Record o1, Record o2) -> (o2.getLastName().compareTo(o1.getLastName()));
    }
}
