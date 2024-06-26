package com.sparta.g1;

public class DataSanitisation {

    private int numberOfCorruptedEntries = 0;

    public boolean checkValidGender(Employee employee) {
        if (employee.gender().equals("M") || employee.gender().equals("F")) {
            return true;
        } else {
            numberOfCorruptedEntries++;
            return false;
        }

    public static boolean isValidEmail(Employee employee) {
        return employee.email().matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$");
    }

}
