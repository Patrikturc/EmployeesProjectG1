package com.sparta.g1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAOImplTests {

    private EmployeeDAOImpl employeeDAO;

    @BeforeEach
    public void setUp() {
        Set<Employee> employees = new HashSet<>(Set.of(
                new Employee("338634", "Ms.", "Paz", "T", "Pearman", "F", "paz.pearman@gmail.com", LocalDate.of(1960, 2, 28), LocalDate.of(1982, 5, 25), "144804"),
                new Employee("178566", "Mrs.", "Juliette", "M", "Rojo", "F", "juliette.rojo@yahoo.co.uk", LocalDate.of(1967, 5, 8), LocalDate.of(2011, 6, 4), "193912"),
                new Employee("496781", "Dr.", "Jonathan", "Z", "Rosa", "M", "jonathan.rosa@gmail.com", LocalDate.of(1981, 2, 19), LocalDate.of(2010, 7, 23), "198838"),
                new Employee("777936", "Ms.", "Nila", "W", "Traylor", "F", "nila.traylor@yahoo.com", LocalDate.of(1972, 5, 6), LocalDate.of(1998, 4, 23), "93058")
        ));
        employeeDAO = new EmployeeDAOImpl(employees);
    }

    @Test
    public void testSearchById() {
        Employee expectedEmployee = new Employee("338634", "Ms.", "Paz", "T", "Pearman", "F", "paz.pearman@gmail.com", LocalDate.of(1960, 2, 28), LocalDate.of(1982, 5, 25), "144804");
        Employee foundEmployee = employeeDAO.searchById("338634");
        Assertions.assertEquals(expectedEmployee, foundEmployee);
    }

    @Test
    public void testSearchByIdNotFound() {
        Employee employee = employeeDAO.searchById("000000");
        Assertions.assertNull(employee);
    }
}