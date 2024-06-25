package com.sparta.g1;


import java.util.ArrayList;


public class EmployeeDAOImpl {
    private ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();

    public EmployeeDTO searchByLastName(String lastName){
        for(EmployeeDTO employee: employeeDTO){

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

