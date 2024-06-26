package com.sparta.g1;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDAOImpl implements EmployeeDAO {

    private ArrayList<Employee> employee = new ArrayList<>();

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

    public List<Employee> searchByHireDateRange(LocalDate startDate, LocalDate endDate){
        return null;
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

