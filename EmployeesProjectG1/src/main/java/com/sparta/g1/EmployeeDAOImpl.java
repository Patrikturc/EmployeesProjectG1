package com.sparta.g1;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class EmployeeDAOImpl implements EmployeeDAO {

    private ArrayList<EmployeeDTO> employeeDTO = new ArrayList<>();
    private Set<EmployeeDTO> employeeSet;

    public EmployeeDAOImpl(Set<EmployeeDTO> employeeList) {
        this.employeeSet = new HashSet<>(employeeList);
    }


    public EmployeeDTO searchById(String id) {
        EmployeeDTO foundEmployee = null;

//        for (EmployeeDTO employee : employeeDTO) {
//            if (employee.empID() == id) {
//                foundEmployee = employee;
//            }
//        }


        return null;
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

    @Override
    public List<EmployeeDTO> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        return employeeSet.stream().filter(employeeDTO1 -> !employeeDTO1.dateOfJoining().isBefore(startDate) && !employeeDTO1.dateOfJoining().isAfter(endDate)).collect(Collectors.toList());
    }

    public List<EmployeeDTO> searchByAgeRange(int minAge, int maxAge) {
        List<EmployeeDTO> employeeList = new ArrayList<>();

        LocalDate currentDate = LocalDate.now();

        for (EmployeeDTO employee : employeeDTO) {
            int employeeAge = currentDate.getYear() - employee.dob().getYear();
            if (employeeAge >= minAge && employeeAge <= maxAge) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}

