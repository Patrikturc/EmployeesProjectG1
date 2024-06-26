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
        ArrayList<EmployeeDTO> employeeList = EmployeeDataConverter.getListOfEmployees();

        Set<EmployeeDTO> employeeSet = new HashSet<>(employeeList);

//        employeeSet = employeeSet.stream().filter(employeeDTO -> employeeDTO.dateOfJoining() != null).collect(Collectors.toSet());

        EmployeeDAO employeeDAO = new EmployeeDAOImpl(employeeSet);

        LocalDate startDate = LocalDate.of(2018, 1, 1);
        LocalDate endDate = LocalDate.of(2019, 12, 31);

        List<EmployeeDTO> result = employeeDAO.searchByHireDateRange(startDate, endDate);
        result.forEach(employeeDTO -> System.out.println(employeeDTO.firstName() + " " + employeeDTO.lastName() + " " + employeeDTO.dateOfJoining()));

    }
}
