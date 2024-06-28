package com.sparta.g1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeDAOImpl implements EmployeeDAO {

    private ArrayList<Employee> employee = new ArrayList<>();

    private Set<Employee> employeeSet;

    public EmployeeDAOImpl(Set<Employee> employeeList) {
        this.employeeSet = new HashSet<>(employeeList);
    }

    @Override
    public Employee searchById(String id) {
        Employee foundEmployee = null;

        for (Employee employee : employee) {
            if (employee.empId().equals(id)) {
                foundEmployee = employee;
            }
        }


        return foundEmployee;
    }
    @Override
    public List<Employee> searchByLastName (String lastName){
        return employeeSet.stream().filter(employee -> employee.lastName().toLowerCase().contains(lastName.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        return employeeSet.stream().filter(employee -> !employee.dateOfJoining().isBefore(startDate) && !employee.dateOfJoining().isAfter(endDate)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> searchByAgeRange(int minAge, int maxAge) {
        List<Employee> employeeList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (Employee employee : employeeSet) {
            int employeeAge = currentDate.getYear() - employee.dob().getYear();
            if (employeeAge >= minAge && employeeAge <= maxAge) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}

