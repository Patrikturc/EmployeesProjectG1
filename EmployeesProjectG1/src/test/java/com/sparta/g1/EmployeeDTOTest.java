package com.sparta.g1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeDTOTest {
    public static Employee employee = new Employee("496781",
            "Dr.",
            "Jonathan",
            "Z",
            "Rosa",
            "M",
            "jonathan.rosa@gmail.com",
            LocalDate.of(1981, 2, 19),
            LocalDate.of(2010, 7, 23),
            "198838");

    @Test
    public void testEmployeeId() {
        assertEquals("496781", employee.empId());
    }

    @Test
    public void testEmployeeTitle() {
        assertEquals("Dr.", employee.prefix());
    }

    @Test
    public void testEmployeeFirstName() {
        assertEquals("Jonathan", employee.firstName());
    }

    @Test
    public void testEmployeeMiddleInitial() {
        assertEquals("Z", employee.middleInitial());
    }

    @Test
    public void testEmployeeLastName() {
        assertEquals("Rosa", employee.lastName());
    }

    @Test
    public void testEmployeeGender() {
        assertEquals("M", employee.gender());
    }

    @Test
    public void testEmployeeEmail() {
        assertEquals("jonathan.rosa@gmail.com", employee.email());
    }

    @Test
    public void testEmployeeDateOfBirth() {
        assertEquals(LocalDate.of(1981, 2, 19), employee.dob());
    }

    @Test
    public void testEmployeeHireDate() {
        assertEquals(LocalDate.of(2010, 7, 23), employee.dateOfJoining());
    }

    @Test
    public void testEmployeePhoneNumber() {
        assertEquals("198838", employee.salary());
    }

    @Test
    public void testEmployeeToString() {
        String expectedString = "EmployeeDTO{empId=496781, prefix='Dr.', firstName='Jonathan', middleInitial='Z', lastName='Rosa', gender=M, email='jonathan.rosa@gmail.com', dob=1981-02-19, dateOfJoining=2010-07-23, salary=198838}";
        assertEquals(expectedString, employee.toString());
    }
}
