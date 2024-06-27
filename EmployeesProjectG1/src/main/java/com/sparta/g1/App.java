package com.sparta.g1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
import java.util.stream.Collectors;

//This is a comment left by kian
public class App {
    public static void main(String[] args) throws IOException {
//        HashSet<Employee> employeeList = EmployeeDataConverter.getListOfEmployees();
//
//        Set<Employee> employeeSet = new HashSet<>(employeeList);
//
//        employeeSet = employeeSet.stream().filter(employeeDTO -> employeeDTO.dateOfJoining() != null).collect(Collectors.toSet());
//
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl(employeeSet);
//
//        LocalDate startDate = LocalDate.of(2018, 1, 1);
//        LocalDate endDate = LocalDate.of(2019, 12, 31);
//
//        List<Employee> result = employeeDAO.searchByHireDateRange(startDate, endDate);
//        result.forEach(employeeDTO -> System.out.println(employeeDTO.firstName() + " " + employeeDTO.lastName() + " " + employeeDTO.dateOfJoining()));

        AppWindow appWindow = new AppWindow();
//
//        HashSet<Employee> employeeList = new HashSet<>(EmployeeDataConverter.getListOfEmployees());
//        System.out.println("Number of valid entries: " + employeeList.size());
//        System.out.println("Number of corrupted entries: " + DataSanitisation.getNumberOfCorruptedEntries());
//
//        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(employeeList);
//        ArrayList<Employee> lastNameSearch = new ArrayList<>(employeeDAO.searchByLastName("sm"));
//        System.out.println(lastNameSearch);
//        ArrayList<Employee> ageRangeSearch = new ArrayList<>(employeeDAO.searchByAgeRange(20,30));
//        System.out.println(ageRangeSearch);
    }
}
