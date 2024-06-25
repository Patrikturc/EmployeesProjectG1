package com.sparta.g1;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDAO {
    EmployeeDTO searchById(String empID);
    List<EmployeeDTO> searchByLastName(String lastName);
    List<EmployeeDTO> searchByHireDateRange(LocalDate startDate, LocalDate endDate);
    List<EmployeeDTO> searchByAgeRange(int minAge, int maxAge);
}
