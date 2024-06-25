package com.sparta.g1;


import java.util.ArrayList;


public class EmployeeDAOImpl implements EmployeeDAO {
    private ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();

    public EmployeeDTO searchByID(int id) {

        EmployeeDTO foundEmployee = null;

        for (EmployeeDTO employee : employeeDTO) {
            if (employee.getID() == id) {
                foundEmployee = employee;
            }
        }

        // TODO - will return null right now if employee not found, replace with appropriate error handling
        return foundEmployee;
    }
}

