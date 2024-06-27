package com.sparta.g1;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class DataSanitationTest {

    private Employee bibi;
    private Employee eric;
    private Employee Renetta;

    @BeforeEach
    void setup() {
        bibi = new Employee("744723", "Hon.", "Bibi", "H", "Paddock", "F", "bibi.paddock@yahoo.co.in", LocalDate.of(1991,10,20), LocalDate.of(2016,11,2), "87148" );
        eric = new Employee("423093", "Mr.", "Eric", "O", "Manning", "M", "eric.manning@yahoo.com", LocalDate.of(1980,10,20), LocalDate.of(2002,11,2), "149363" );
        Renetta = new Employee("207808", "Ms.", "Renetta", "T", "Hafner", "F", "renetta.hafner@aol.com", LocalDate.of(1975,10,20), LocalDate.of(1998,11,2), "189363" );
    }

    @Test
    @DisplayName("Check if valid email string returns true")
    public void checkIsValidEmailReturnsTrueOnValidEmailInput() {
        String input = "email@email.com";
        Employee employee = new Employee("", "", "", "", "", "", input, "", "", "");
        boolean expected = true;
        boolean actual = DataSanitisation.isValidEmail(employee);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkIdIsValidLength() {
        boolean expected = true;
        boolean actual = DataSanitisation.checkEmpIdIsCorrectLength(bibi);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void checkValidGender() {
        boolean expected = true;
        boolean actual = DataSanitisation.checkValidGender(bibi);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isValidEmail() {
        boolean expected = true;
        boolean actual = DataSanitisation.isValidEmail(bibi);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkDobIsBeforeDoj() {
        boolean expected = true;
        boolean actual = DataSanitisation.checkDobIsBeforeDoj(bibi);
        Assertions.assertEquals(expected, actual);
    }
}
