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
    }

    public boolean checkEmpIdIsCorrectLength(Employee employee) {
        if (employee.empId().length() == 6) {
            return true;
        } else {
            numberOfCorruptedEntries++;
            return false;
        }
    }

}
