package com.sparta.g1;

import java.time.LocalDate;

public record EmployeeDTO(String name, Integer salary, LocalDate dob) {

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dob=" + dob +
                '}';
    }

}