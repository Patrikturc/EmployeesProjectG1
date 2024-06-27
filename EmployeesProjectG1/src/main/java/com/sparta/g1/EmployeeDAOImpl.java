package com.sparta.g1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger logger = AppLogger.getLogger(Level.ALL, Level.INFO, true);

    private ArrayList<Employee> employee = new ArrayList<>();

    private Set<Employee> employeeSet;

    public EmployeeDAOImpl(Set<Employee> employeeList) {
        this.employeeSet = new HashSet<>(employeeList);
    }

    public Employee searchById(String id) {
        logger.log(Level.FINER, "Entered search by id method");

        Employee foundEmployee = null;

        for (Employee employee : employeeSet) {
            if (employee.empId().equals(id)) {
                return employee;
            }
        }

        logger.log(Level.FINER, "Exited search by id method");

        return foundEmployee;

    }

    @Override
    public List<Employee> searchByLastName (String lastName){
        logger.log(Level.FINER, "Entered search by last name method");
        logger.log(Level.FINER, "Exited search by last name method");
        return employeeSet.stream().filter(employee -> employee.lastName().toLowerCase().contains(lastName.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        logger.log(Level.FINER, "Entered search by hire date range method");
        logger.log(Level.FINER, "Exited search by hire date range method");
        return employeeSet.stream().filter(employee -> !employee.dateOfJoining().isBefore(startDate) && !employee.dateOfJoining().isAfter(endDate)).collect(Collectors.toList());
    }

    public List<Employee> searchByAgeRange(int minAge, int maxAge) {
        logger.log(Level.FINER, "Entered search by age range method");
        List<Employee> employeeList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (Employee employee : employeeSet) {
            int employeeAge = currentDate.getYear() - employee.dob().getYear();
            if (employeeAge >= minAge && employeeAge <= maxAge) {
                employeeList.add(employee);
            }
        }

        logger.log(Level.FINER, "Exited search by age range method");
        return employeeList;
    }
}
