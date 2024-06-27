package com.sparta.g1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.reporting.ReportEntry;

import java.time.LocalDate;

public class DataSanitisationTests {
    private Employee bibi;
    private Employee eric;
    private Employee Renetta;
    private Employee fakeDates;

    @BeforeEach
    void setup() {
        bibi = new Employee("744723", "Hon.", "Bibi", "H", "Paddock", "F", "bibi.paddock@yahoo.co.in", LocalDate.of(1991, 10, 20), LocalDate.of(2016, 11, 2), "87148");
        eric = new Employee("423093", "Mr.", "Eric", "O", "Manning", "M", "eric.manning@yahoo.com", LocalDate.of(1980, 10, 20), LocalDate.of(2002, 11, 2), "149363");
        fakeDates = new Employee("207808", "Ms.", "Renetta", "T", "Hafner", "F", "renetta.hafner@aol.com", LocalDate.of(1800, 3, 2), LocalDate.of(1998, 3, 2), "189363");
        Renetta = new Employee("207808", "Ms.", "Renetta", "T", "Hafner", "F", "renetta.hafner@aol.com", LocalDate.of(2055, 1, 2), LocalDate.of(1998, 11, 2), "189363");
    }
    @Test
    @DisplayName("Given an employee has a negative salary then false should be returned")
    void givenNegativeSalaryReturnFalse(){
        //Arrange
        boolean expected = false;

        //Act
        boolean actual = DataSanitisation.isValidSalary("-100000");

        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Check if valid email string returns true")
    public void checkIsValidEmailReturnsTrueOnValidEmailInput() {
        String input = "email@email.com";
        boolean expected = true;
        boolean actual = DataSanitisation.isValidEmail(input);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Check Valid Date of Birth Returns True")
    void checkValidDateOfBirthReturnsTrue() {
        String input = "03/12/1970";
        Boolean expected = true;
        boolean actual = DataSanitisation.isDateOfBirthValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check Invalid Date of Birth Returns False")
    void checkInvalidDateOfBirthReturnsFalse() {
        String input = "03/12/1000";
        Boolean expected = false;
        boolean actual = DataSanitisation.isDateOfBirthValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check Valid Date of Joining Returns True")
    void checkValidDateOfJoiningReturnsTrue() {
        String input = "03/12/2000";
        Boolean expected = true;
        boolean actual = DataSanitisation.isDateOfJoiningValid(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check Invalid Date of Joining Returns False")
    void checkInvalidDateOfJoiningReturnsFalse() {
        String input = "03/12/2025";
        Boolean expected = false;
        boolean actual = DataSanitisation.isDateOfJoiningValid(input);
        Assertions.assertEquals(expected, actual);
    }
}


