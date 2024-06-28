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

    //1. isValidID
    //2. isValidPrefix
    //3. valid first name?
    //4. valid middle initial
    //5. valid last name
    //6. isValidGender
    //7. isValidEmail
    //8. isValidDoB
    //9. isValidDoJ
    //10. isValidSalary

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


    private static boolean isValidDayOfMonth(int month, int day, int year) {
        if (((month == 4 || month == 6 || month == 9
                || month == 11) && day > 30)) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year) && day > 29) {
                return false;
            } else if (!isLeapYear(year) && day > 28) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
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

            if (month < 1 || month > 12 ||
                    day < 1 || day > 31 ||
                    year < 1924 || year > LocalDate.now().getYear()) {
                numberOfCorruptedEntries++;
                return false;
            }
            if (!isValidDayOfMonth(month, day, year)) {
                numberOfCorruptedEntries++;
                return false;
            }
            return true;

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

            if (month < 1 || month > 12 ||
                    day < 1 || day > 31 ||
                    year < 1979 || year > LocalDate.now().getYear()) {
                numberOfCorruptedEntries++;
                return false;
            }
            if (!isValidDayOfMonth(month, day, year)) {
                numberOfCorruptedEntries++;
                return false;
            }
            return true;

        } catch (NumberFormatException | DateTimeParseException e) {
            numberOfCorruptedEntries++;
        }
        return false;
    }








}

