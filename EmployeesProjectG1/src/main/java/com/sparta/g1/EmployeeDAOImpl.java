package com.sparta.g1;


import java.util.ArrayList;


public class EmployeeDAOImpl implements EmployeeDAO {
    private ArrayList<EmployeeDTO> employeeDTOS = new ArrayList<>();

    public EmployeeDTO searchByLastName(String lastName){
        for(EmployeeDTO employee: employeeDTOS){
            if(employee.getLastName()
                    .toLowerCase()
                    .contains(lastName.toLowerCase())){
                return employee;
                break;
            }
        }
        return null;
    }
}

