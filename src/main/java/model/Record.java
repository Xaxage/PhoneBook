package main.java.model;

public class Record {
    private String firstName;
    private String lastName;
    private String phone;
    private boolean correctSeparator = true;
    private boolean correctPhone = false;
    private String fullRecord;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        if (phone.length() == 9) {
            correctPhone = true;
        }
    }

    public boolean isCorrectSeparator() {
        return correctSeparator;
    }

    public void setCorrectSeparator(boolean correctSeparator) {
        this.correctSeparator = correctSeparator;
    }

    public boolean isCorrectPhone() {
        return correctPhone;
    }

    public String getFullRecord() {
        return fullRecord;
    }

    public void setFullRecord(String fullRecord) {
        this.fullRecord = fullRecord;
    }
}
