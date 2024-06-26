package com.sparta.g1;

public class DataSanitisation {

    private int numberOfCorruptedEntries = 0;

    public boolean checkValidGender(EmployeeDTO employee) {
        return employee.gender() == 'M' || employee.gender() == 'F';
    }
}
