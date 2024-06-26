package com.sparta.g1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataSanitisation {

    private static int numberOfCorruptedEntries = 0;

    public static boolean checkValidGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {
            return true;
        } else {
            numberOfCorruptedEntries++;
            return false;
        }
    }
    public static boolean isValidEmail (String email){
        if (email.matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")){
            return true;
        }else{
            numberOfCorruptedEntries++;
            return false;
        }
    }

    public static boolean checkEmpIdIsCorrectLength (String empId){
        if (empId.length() == 6) {
            return true;
        } else {
            numberOfCorruptedEntries++;
            return false;
        }
    }

    public static boolean isValidSalary(String salary){
        if(Integer.parseInt(salary)<0){
            numberOfCorruptedEntries++;
            return false;
        }
        return true;
    }

    public static int getNumberOfCorruptedEntries () {
        return numberOfCorruptedEntries;
    }

    public static DateTimeFormatter formatDates () {
        return DateTimeFormatter.ofPattern("[MM/dd/yyyy][M/d/yyyy][M/dd/yyyy][M/d/yyyy]");
    }

}

