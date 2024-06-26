package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDataConverter {
    private static String[] employeeDataReader = new String[0];
    private static ArrayList<Employee> listOfEmployees;


    public static void employeeDataConverter() throws IOException {
        listOfEmployees = new ArrayList<>();
        employeeDataReader = EmployeeFactory.getEmployees(500);
        for (String employeeRecord : employeeDataReader){
            listOfEmployees.add(createEmployeeFromData(employeeRecord));
        }
    }

    private static Employee createEmployeeFromData(String data) {
        String[] parts = data.split(",");
        if (parts.length != 10) throw new IllegalArgumentException("Invalid data format");

        int empID = Integer.parseInt(parts[0]);
        String prefix = parts[1];
        String firstName = parts[2];
        char middleInitial = parts[3].charAt(0);
        String lastName = parts[4];
        char gender = parts[5].charAt(0);
        String email = parts[6];
        LocalDate dateOfBirth = LocalDate.parse(parts[7]);
        LocalDate dateOfJoining = LocalDate.parse(parts[8]);
        int salary = Integer.parseInt(parts[9]);

        return new Employee(empID, prefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary);
    }

    public static ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

}
