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
}
