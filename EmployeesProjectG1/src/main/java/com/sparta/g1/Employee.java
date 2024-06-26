package com.sparta.g1;

import java.time.LocalDate;

public record Employee(int empId,
                       String prefix,
                       String firstName,
                       char middleInitial,
                       String lastName,
                       char gender,
                       String email,
                       LocalDate dob,
                       LocalDate dateOfJoining,
                       Integer salary) {

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empID=" + empId +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }
}