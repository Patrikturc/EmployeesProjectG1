package com.sparta.g1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DataSanitisationTests {

    private Employee bibi;
    private Employee eric;
    private Employee Renetta;
    private Employee john;
    private Employee jane;
    private Employee bob;
    private Employee alice;


    @BeforeEach
    void setup() {
        bibi = new Employee("744723", "Hon.", "Bibi", "H", "Paddock", "F", "bibi.paddock@yahoo.co.in", LocalDate.of(1991,10,20), LocalDate.of(2016,11,2), "87148" );
        eric = new Employee("423093", "Mr.", "Eric", "O", "Manning", "M", "eric.manning@yahoo.com", LocalDate.of(1980,10,20), LocalDate.of(2002,11,2), "149363" );
        Renetta = new Employee("207808", "Ms.", "Renetta", "T", "Hafner", "F", "renetta.hafner@aol.com", LocalDate.of(1975,10,20), LocalDate.of(1998,11,2), "189363" );
        // Incorrect gender
        Employee john = new Employee("123456", "Mr.", "John", "D", "Doe", "X", "john.doe@gmail.com", LocalDate.of(1980,1,1), LocalDate.of(2000,1,1), "123456");
        // Incorrect email
        Employee jane = new Employee("654321", "Ms.", "Jane", "D", "Doe", "F", "jane.doegmail.com", LocalDate.of(1985,1,1), LocalDate.of(2005,1,1), "654321");
        // Incorrect employee ID length
        Employee bob = new Employee("7890", "Mr.", "Bob", "B", "Builder", "M", "bob.builder@gmail.com", LocalDate.of(1970,1,1), LocalDate.of(1990,1,1), "789012");
        // Date of birth is not before date of joining
        Employee alice = new Employee("987654", "Ms.", "Alice", "A", "Adams", "F", "alice.adams@gmail.com", LocalDate.of(2000,1,1), LocalDate.of(1990,1,1), "987654");

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
    public void checkIdIsValidLength() {
        boolean expected = true;
        boolean actual = DataSanitisation.checkEmpIdIsCorrectLength(bibi.empId());
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void checkValidGender() {
        boolean expected = true;
        boolean actual = DataSanitisation.checkValidGender(bibi.gender());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isValidEmail() {
        boolean expected = true;
        boolean actual = DataSanitisation.isValidEmail(bibi.email());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkDobIsBeforeDoj() {
        boolean expected = true;
        boolean actual = DataSanitisation.checkDobIsBeforeDoj(bibi);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkValidGenderForJohn() {
        boolean expected = false;
        boolean actual = DataSanitisation.checkValidGender(john.gender());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isValidEmailForJane() {
        boolean expected = false;
        boolean actual = DataSanitisation.isValidEmail(jane.email());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkEmpIdIsCorrectLengthForBob() {
        boolean expected = false;
        boolean actual = DataSanitisation.checkEmpIdIsCorrectLength(bob.empId());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkDobIsBeforeDojForAlice() {
        boolean expected = false;
        boolean actual = DataSanitisation.checkDobIsBeforeDoj(alice);
        Assertions.assertEquals(expected, actual);
    }
}


