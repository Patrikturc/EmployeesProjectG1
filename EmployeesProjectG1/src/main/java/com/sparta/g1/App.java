package com.sparta.g1;

import javax.xml.crypto.Data;
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
        ArrayList<Employee> employeeList = EmployeeDataConverter.getListOfEmployees();

        Set<Employee> employeeSet = new HashSet<>(employeeList);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(employeeSet);

        LocalDate startDate = LocalDate.of(1999, 1, 1);
        LocalDate endDate = LocalDate.of(2005, 12, 31);

        List<Employee> result = employeeDAO.searchByHireDateRange(startDate, endDate);

        for (Employee employee : result) {
        System.out.println(employee.firstName() + " " + employee.lastName() + " " + employee.dateOfJoining());
        }
        System.out.println(result.size() + " " + DataSanitisation.getNumberOfCorruptedEntries());





    }
}
