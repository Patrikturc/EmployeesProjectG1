package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

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

    public static boolean checkDobIsBeforeDoj(Employee employee) {
        if (employee.dob().isBefore(employee.dateOfJoining())) {
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

    public static boolean isDateOfBirthValid(String dateOfBirth) {
        String[] parts = dateOfBirth.split("/");
        if (parts.length != 3) {
            numberOfCorruptedEntries++;
            return false;
        }
        try {
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                numberOfCorruptedEntries++;
                return false;
            }
            if (day < 1 || day > 31) {
                numberOfCorruptedEntries++;
                return false;
            }
            if (year >= 1924 && year <= LocalDate.now().getYear()) {
                return true;
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            numberOfCorruptedEntries++;
        }
        return false;
    }

    public static boolean isDateOfJoiningValid(String dateOfJoining) {
        String[] parts = dateOfJoining.split("/");
        if (parts.length != 3) {
            numberOfCorruptedEntries++;
            return false;
        }
        try {
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                numberOfCorruptedEntries++;
                return false;
            }
            if (day < 1 || day > 31) {
                numberOfCorruptedEntries++;
                return false;
            }
            if (year >= 1979 && year <= LocalDate.now().getYear()) {
                return true;
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            numberOfCorruptedEntries++;
        }
        return false;
    }





}

