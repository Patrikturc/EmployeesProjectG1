package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmployeeDataConverter {

    private static final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);

    public static HashSet<Employee> employeeDataConverter() throws IOException {
        logger.log(Level.FINER, "Entered employee data converter method");

        HashSet<Employee> listOfEmployees = new HashSet<>();
        String[] employeeDataReader = EmployeeFactory.getEmployees(500);
        for (String employeeRecord : employeeDataReader){
            listOfEmployees.add(createEmployeeFromData(employeeRecord));
        }
        listOfEmployees.remove(null);

        logger.log(Level.FINER, "Exited employee data converter method");
        return listOfEmployees;
    }

    private static Employee createEmployeeFromData(String data) {
        logger.log(Level.FINER, "Entered create employee from data method");

        String[] parts = data.split(",");
        if (parts.length != 10) throw new IllegalArgumentException("Invalid data format");
        if (!isValidEmployee(parts)) {
            logger.log(Level.FINEST, "Found another corrupt employee entry");
            return null;
        }
        String empID = String.valueOf(Integer.parseInt(parts[0]));
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


    private static boolean isValidEmployee(String[] parts) {
        logger.log(Level.FINER, "Entered is valid employee method");
        logger.log(Level.FINER, "Exited is valid employee method");
        return DataSanitisation.checkEmpIdIsCorrectLength(String.valueOf(Integer.parseInt(parts[0]))) &&
                DataSanitisation.checkValidGender(String.valueOf(parts[5].charAt(0))) &&
                DataSanitisation.isValidEmail(parts[6]) &&
                DataSanitisation.isDateOfBirthValid(parts[7]) &&
                DataSanitisation.isDateOfJoiningValid(parts[8]) &&
                DataSanitisation.isValidSalary(parts[9]);

    }

    public static HashSet<Employee> getListOfEmployees() throws IOException {
        logger.log(Level.FINER, "Entered get list of employees method");
        logger.log(Level.FINER, "Exited get list of employees method");
        return employeeDataConverter();
    }

}
