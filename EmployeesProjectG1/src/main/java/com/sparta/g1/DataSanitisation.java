package com.sparta.g1;

public class DataSanitisation {

    private int numberOfCorruptedEntries = 0;

    public boolean checkValidGender(Employee employee) {
        return employee.gender() == 'M' || employee.gender() == 'F';
    }

    public static boolean isValidEmail(Employee employee) {
        return employee.email().matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$");
    }
}
