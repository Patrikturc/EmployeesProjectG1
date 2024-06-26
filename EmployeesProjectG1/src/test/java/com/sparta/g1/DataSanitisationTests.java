package com.sparta.g1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataSanitisationTests {

    @Test
    @DisplayName("Given an employee has a negative salary then false should be returned")
    void givenNegativeSalaryReturnFalse(){
        //Arrange
        boolean expected = false;

        //Act
        DataSanitisation dataSanitisation = new DataSanitisation();
        boolean actual = dataSanitisation.checkValidPositiveSalary(new Employee("1","","","","","","","","","-100000"));

        //Assert
        Assertions.assertEquals(expected,actual);
    }
}
