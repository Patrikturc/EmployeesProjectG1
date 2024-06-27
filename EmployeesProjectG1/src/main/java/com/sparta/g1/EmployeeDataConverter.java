package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;


public class EmployeeDataConverter {


    public static HashSet<Employee> employeeDataConverter() throws IOException {
        HashSet<Employee> listOfEmployees = new HashSet<>();
        String[] employeeDataReader = EmployeeFactory.getEmployees(500);
        for (String employeeRecord : employeeDataReader){
            listOfEmployees.add(createEmployeeFromData(employeeRecord));
        }
        listOfEmployees.remove(null);
        return listOfEmployees;
    }

    private static Employee createEmployeeFromData(String data) {
        String[] parts = data.split(",");
        if (parts.length != 10) throw new IllegalArgumentException("Invalid data format");
        else if(!DataSanitisation.checkEmpIdIsCorrectLength(parts[0])){
            return null;
        }
        else if(!DataSanitisation.checkValidGender(String.valueOf(parts[5].charAt(0)))){
            return null;
        }
        else if(!DataSanitisation.isValidEmail(parts[6])){
            return null;
        }
        else if(!DataSanitisation.isValidSalary(parts[9])){
            return null;
        }
        else {
            String empID = parts[0];
            String prefix = parts[1];
            String firstName = parts[2];
            String middleInitial = String.valueOf(parts[3].charAt(0));
            String lastName = parts[4];
            String gender = String.valueOf(parts[5].charAt(0));
            String email = parts[6];
            LocalDate dateOfBirth = LocalDate.parse(parts[7], DataSanitisation.formatDates());
            LocalDate dateOfJoining = LocalDate.parse(parts[8], DataSanitisation.formatDates());
            String salary = String.valueOf(Integer.parseInt(parts[9]));

            return new Employee(empID, prefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
        }
    }

    public static HashSet<Employee> getListOfEmployees() throws IOException {
        return employeeDataConverter();
    }



}
