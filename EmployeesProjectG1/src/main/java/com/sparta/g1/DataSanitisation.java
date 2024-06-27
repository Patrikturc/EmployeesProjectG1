package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSanitisation {

    private static final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);

    private static int numberOfCorruptedEntries = 0;

    public static boolean checkValidGender(String gender) {
        logger.log(Level.FINER, "Entered check valid gender method");

        if (gender.equals("M") || gender.equals("F")) {
            logger.log(Level.FINER, "Exited check valid gender method with true return");
            return true;
        } else {
            numberOfCorruptedEntries++;
            logger.log(Level.FINEST, "Found one more corrupted employee");
            logger.log(Level.FINER, "Exited check valid gender method with false return");
            return false;
        }
    }

    public static boolean isValidEmail (String email){
        logger.log(Level.FINER, "Entered is valid email method");

        if (email.matches("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$")){
            logger.log(Level.FINER, "Exited is valid email method with true return");
            return true;
        }else{
            logger.log(Level.FINEST, "Found one more corrupted employee");
            logger.log(Level.FINER, "Exited is valid email method with false return");
            numberOfCorruptedEntries++;
            return false;
        }
    }

    public static boolean checkEmpIdIsCorrectLength (String empId){
        logger.log(Level.FINER, "Entered check employee id is correct length method");
        if (empId.length() == 6) {
            logger.log(Level.FINER, "Exited check employee id is correct length method with true return");
            return true;
        } else {
            logger.log(Level.FINEST, "Found one more corrupted employee");
            logger.log(Level.FINER, "Exited check employee id is correct length method with False return");
            numberOfCorruptedEntries++;
            return false;
        }
    }

    public static boolean checkDobIsBeforeDoj(Employee employee) {
        logger.log(Level.FINER, "Entered check date of birth before date of joining method");
        if (employee.dob().isBefore(employee.dateOfJoining())) {
            logger.log(Level.FINER, "Exited check date of birth before date of joining method with true return");
            return true;
        } else {
            logger.log(Level.FINEST, "Found one more corrupted employee");
            logger.log(Level.FINER, "Exited check date of birth before date of joining method with false return");
            numberOfCorruptedEntries++;
            return false;
        }
    }

    public static boolean isValidSalary(String salary){
        logger.log(Level.FINER, "Entered check is valid salary method");
        if(Integer.parseInt(salary)<0){
            logger.log(Level.FINEST, "Found one more corrupted employee");
            logger.log(Level.FINER, "Exited check is valid salary method with false return");
            numberOfCorruptedEntries++;
            return false;
        }
        logger.log(Level.FINER, "Exited check date of birth before date of joining method with true return");
        return true;
    }

    public static int getNumberOfCorruptedEntries() {
        logger.log(Level.FINER, "Entered get number of corrupted employees method");
        logger.log(Level.FINER, "Exited get number of corrupted employees method");
        return numberOfCorruptedEntries;
    }

    public static DateTimeFormatter formatDates() {
        logger.log(Level.FINER, "Entered format date method");
        logger.log(Level.FINER, "Exited format date method");
        return DateTimeFormatter.ofPattern("[MM/dd/yyyy][M/d/yyyy][M/dd/yyyy][M/d/yyyy]");
    }

}

