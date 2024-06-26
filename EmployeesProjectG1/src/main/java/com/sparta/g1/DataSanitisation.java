package com.sparta.g1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataSanitisation {


    private static int numberOfCorruptedEntries = 0;

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

    public boolean checkEmpIdIsCorrectLength(Employee employee) {
        if (employee.empId().length() == 6) {
            return true;
        } else {
            numberOfCorruptedEntries++;
            return false;
        }
    }

    public static int getNumberOfCorruptedEntries() {
        return numberOfCorruptedEntries;
    }

    public static DateTimeFormatter formatDates() {
        return DateTimeFormatter.ofPattern("[MM/dd/yyyy][M/d/yyyy][M/dd/yyyy][M/d/yyyy]");
    }

}
