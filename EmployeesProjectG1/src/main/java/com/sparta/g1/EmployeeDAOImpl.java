package com.sparta.g1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeDAOImpl implements EmployeeDAO {

    private ArrayList<Employee> employee = new ArrayList<>();
    private ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();
    private Set<EmployeeDTO> employeeSet;

    public EmployeeDAOImpl(Set<EmployeeDTO> employeeList) {
        this.employeeSet = new HashSet<>(employeeList);
    }


    public Employee searchById(String id) {
        Employee foundEmployee = null;

        for (Employee employee : employee) {
            if (employee.getID().equals(id)) {
                foundEmployee = employee;
            }
        }


        return foundEmployee;
    }

    public List<Employee> searchByLastName (String lastName){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employee) {

            if (employee.lastName()
                    .toLowerCase()
                    .contains(lastName.toLowerCase())) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDTO> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        return employeeSet.stream().filter(employeeDTO1 -> !employeeDTO1.dateOfJoining().isBefore(startDate) && !employeeDTO1.dateOfJoining().isAfter(endDate)).collect(Collectors.toList());
    }

    public List<Employee> searchByAgeRange(int minAge, int maxAge) {
        List<Employee> employeeList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        for (Employee employee : employee) {
            int employeeAge = currentDate.getYear() - employee.dob().getYear();
            if (employeeAge >= minAge && employeeAge <= maxAge) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}

