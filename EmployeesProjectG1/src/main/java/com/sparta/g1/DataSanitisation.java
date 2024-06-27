package com.sparta.g1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSanitisation {

    private static final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);

    private static int numberOfCorruptedEntries = 0;

    public static boolean checkValidGender(String gender) {
        logger.log(Level.INFO, "Entered check valid gender method");

        if (gender.equals("M") || gender.equals("F")) {
            logger.log(Level.INFO, "Exited check valid gender method");
            return true;
        } else {
            numberOfCorruptedEntries++;
            logger.log(Level.INFO, "Exited check valid gender method");
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

}

