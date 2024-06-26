package com.sparta.g1;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDAO {
    Employee searchById(String empID);
    List<Employee> searchByLastName(String lastName);
    List<Employee> searchByHireDateRange(LocalDate startDate, LocalDate endDate);
    List<Employee> searchByAgeRange(int minAge, int maxAge);
}