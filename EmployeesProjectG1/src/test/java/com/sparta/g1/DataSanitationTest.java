package com.sparta.g1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataSanitationTest {

    @Test
    @DisplayName("Check if valid email string returns true")
    public void checkIsValidEmailReturnsTrueOnValidEmailInput() {
        String input = "email@email.com";
        Employee employee = new Employee("", "", "", "", "", "", input, "", "", "");
        boolean expected = true;
        boolean actual = DataSanitisation.isValidEmail(employee);
        Assertions.assertEquals(expected, actual);
    }

}
