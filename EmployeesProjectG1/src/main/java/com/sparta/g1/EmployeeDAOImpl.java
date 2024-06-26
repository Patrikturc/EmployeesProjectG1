package com.sparta.g1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class EmployeeDAOImpl implements EmployeeDAO {
  
    private ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();


    public EmployeeDTO searchById(String id) {
        EmployeeDTO foundEmployee = null;

        for (EmployeeDTO employee : employeeDTO) {
            if (employee.getID().equals(id)) {
                foundEmployee = employee;
            }
        }


        return foundEmployee;
    }

        public List<EmployeeDTO> searchByLastName (String lastName){
            List<EmployeeDTO> employeeList = new ArrayList<>();
            for (EmployeeDTO employee : employeeDTO) {

                if (employee.lastName()
                        .toLowerCase()
                        .contains(lastName.toLowerCase())) {
                    employeeList.add(employee);
                }
            }
            return employeeList;
        }

        public List<EmployeeDTO> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        return null;
        }

        public List<EmployeeDTO> searchByAgeRange(int minAge, int maxAge){
            List<EmployeeDTO> employeeList = new ArrayList<>();

            LocalDate currentDate = LocalDate.now();

            for (EmployeeDTO employee : employeeDTO){
                int employeeAge = currentDate.getYear() - employee.dob().getYear();
                if(employeeAge >= minAge && employeeAge <= maxAge){
                    employeeList.add(employee);
                }
            }
            return employeeList;
        }
        return employeeList;
    }

    public List<EmployeeDTO> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        return null;
    }

    public List<EmployeeDTO> searchByAgeRange(int minAge, int maxAge){
        List<EmployeeDTO> employeeList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        for (EmployeeDTO employee : employeeDTO){
            int employeeAge = currentDate.getYear() - employee.dob().getYear();
            if(employeeAge >= minAge && employeeAge <= maxAge){
                employeeList.add(employee);
            }
        }
    }
}
