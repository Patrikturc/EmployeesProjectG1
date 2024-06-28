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
}
