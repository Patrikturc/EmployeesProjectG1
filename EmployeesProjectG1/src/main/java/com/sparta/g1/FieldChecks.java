package com.sparta.g1;

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
