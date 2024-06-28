package com.sparta.g1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FieldChecks {
    private static final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);

    public static boolean hasValidID(String empID){
        logger.log(Level.FINER, "Entered has Valid ID method");
        if(empID == null || empID.length() != 6){
            logger.log(Level.FINEST, "ID Invalid due to incorrect length returned with false");
            return false;
        }
        else if(empID.matches("[0-9]+")){
            logger.log(Level.FINEST, "ID is valid returned with true");
            return true;
        }

        else{
            logger.log(Level.FINEST, "ID is invalid as non digits present returned with false");
            return false;
        }
    }

    public static boolean hasValidPartialName(String partialName){
        logger.log(Level.FINER, "Entered hasValidPartialName method");
        if(partialName == null || partialName.isEmpty()){
            logger.log(Level.FINEST, "partial name is invalid as String is empty returned false");
            return false;
        }
        else if(partialName.matches("[a-zA-z]+")){
            logger.log(Level.FINEST, "partial name is valid returned true");
            return true;
        }
        else{
            logger.log(Level.FINEST, "partial name is invalid as contains non alphabet characters returned false");
            return false;
        }
    }

    public static boolean hasValidDates(String date1, String date2){
        logger.log(Level.FINER, "Entered hasValidDates method");
        if(date1.length() <8 || date2.length() <8 || date1.length()>10 || date2.length() >10){
            logger.log(Level.FINEST, "Dates are invalid as incorrect length returned false");
            return false;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.MONTH_OF_YEAR,1,2, SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(ChronoField.DAY_OF_MONTH,1,2,SignStyle.NEVER)
                .appendLiteral('/')
                .appendValue(ChronoField.YEAR,4)
                .toFormatter();
        try{
            LocalDate.parse(date1, formatter);
            LocalDate.parse(date2, formatter);
            logger.log(Level.FINEST, "Dates are valid format returned true");
            return true;
        }
        catch (DateTimeParseException e){
            logger.log(Level.FINEST, "Dates are invalid format returned false");
            return false;
        }
    }

    public static boolean hasValidAgeRange(String age1, String age2){
        logger.log(Level.FINER, "Entered hasValidAgeRange method");
        if(age1 == null || age2 == null || age1.isEmpty() || age2.isEmpty()){
            logger.log(Level.FINEST, "Ages are invalid due to being empty returned false");
            return false;
        }
        if(age1.matches("[0-9]+") && age2.matches("[0-9]+")){
            logger.log(Level.FINEST, "Ages are all numerical, checking to see if ages are sensible");
            int ageOneInt = Integer.parseInt(age1);
            int ageTwoInt = Integer.parseInt(age2);
            return ageOneInt >= 0 && ageTwoInt >= 0 && ageTwoInt <= 120 && ageOneInt <= ageTwoInt;
        }
        logger.log(Level.FINEST, "Ages are invalid due to not being all numerical returned false");
        return false;
    }
}
