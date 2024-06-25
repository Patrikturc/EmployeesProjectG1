package com.sparta.g1;


import java.util.ArrayList;


public class EmployeeDAOImpl {
    private ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();

    public EmployeeDTO searchByID(String id) {
        EmployeeDTO foundEmployee = null;

        for (EmployeeDTO employee : employeeDTO) {
            if (employee.getID().equals(id)) {
                foundEmployee = employee;
            }
        }

        return foundEmployee;
    }
}

