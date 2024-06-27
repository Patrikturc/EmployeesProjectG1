package com.sparta.g1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DataSanitisationTests {

    @Test
    @DisplayName("Given an employee has a negative salary then false should be returned")
    void givenNegativeSalaryReturnFalse(){
        //Arrange
        boolean expected = false;

        //Act
        boolean actual = DataSanitisation.isValidSalary(new Employee("1","","","","","","", "","","-100000"));

        //Assert
        Assertions.assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Given an employee has a positive salary then true should be returned")
    void givenNegativeSalaryReturnFalse(){
        //Arrange
        boolean expected = false;

        //Act
        boolean actual = DataSanitisation.isValidSalary(new Employee("1","","","","","","","","","100000"));

        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if valid email string returns true")
    public void checkIsValidEmailReturnsTrueOnValidEmailInput() {
        String input = "email@email.com";
//        Employee employee = new Employee("", "", "", "", "", "", input, "", "", "");
        boolean expected = true;
        boolean actual = DataSanitisation.isValidEmail(input);
        Assertions.assertEquals(expected, actual);
    }
}

