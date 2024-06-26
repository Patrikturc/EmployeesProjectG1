package com.sparta.g1;


import java.util.ArrayList;


public class EmployeeDAOImpl {
    private ArrayList<Employee> employeeDTO = new ArrayList<>();


    public Employee searchByID(String id) {
        Employee foundEmployee = null;

        for (EmployeeDTO employee : employeeDTO) {
            if (employee.getID().equals(id)) {
                foundEmployee = employee;
            }
        }


        return foundEmployee;
    }

        public Employee searchByLastName (String lastName){
            for (Employee employee : employeeDTO) {

                if (employee.getLastName()
                        .toLowerCase()
                        .contains(lastName.toLowerCase())) {
                    return employee;
                    break;
                }
            }
            return null;
        }
    }


