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

public class FieldChecks {

    public static boolean hasValidID(String empID){
        if(empID == null || empID.length() != 6){
            return false;
        }
        else if(empID.matches("[0-9]+")){
            return true;
        }
        else return false;
    }

    public static boolean hasValidPartialName(String partialName){
        if(partialName == null || partialName.isEmpty()){
            return false;
        }
        else if(partialName.matches("[a-zA-z]+")){
            return true;
        }
        else return false;
    }

    public static boolean hasValidDates(String date1, String date2){
        if(date1.length() <8 || date2.length() <8 || date1.length()>10 || date2.length() >10){
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
            return true;
        }
        catch (DateTimeParseException e){
            return false;
        }
    }

    public static boolean hasValidAgeRange(String age1, String age2){
        if(age1 == null || age2 == null || age1.isEmpty() || age2.isEmpty()){
            return false;
        }
        if(age1.matches("[0-9]+") && age2.matches("[0-9]+")){
            int ageOneInt = Integer.parseInt(age1);
            int ageTwoInt = Integer.parseInt(age2);
            return ageOneInt >= 0 && ageTwoInt >= 0 && ageTwoInt <= 120 && ageOneInt <= ageTwoInt;
        }
        return false;
    }
}
