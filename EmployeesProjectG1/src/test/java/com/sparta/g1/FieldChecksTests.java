package com.sparta.g1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FieldChecksTests {
    @Test
    @DisplayName("Given an input of hu then ageCheck returns false")
    void givenInputWithLettersAgeCheckReturnsFalse(){
        String input = "hu";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidAgeRange(input,input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenInputStringContainingOnlyNumbersReturnsTrue(){
        String input = "22";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidAgeRange(input,input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenTwoInputStringOneContainingNumbersOneContainingLettersReturnFalse(){
        String input = "9u";
        String input2 = "87";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidAgeRange(input,input2);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenTwoInputStringFirstHigherThanSecondReturnFalse(){
        String input = "57";
        String input2 = "42";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidAgeRange(input,input2);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenTwoInputStringOneHigherThan120ReturnFalse(){
        String input = "57";
        String input2 = "127";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidAgeRange(input,input2);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenNullStringReturnFalseForIDCheck(){
        String input = null;
        boolean expected = false;
        boolean actual = FieldChecks.hasValidID(input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenStringLengthLessThanSixReturnFalseForIDCheck(){
        String input = "12345";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidID(input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenStringLengthOfSixThenReturnTrueForIDCheck(){
        String input = "123456";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidID(input);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void givenStringLengthOfSixAndIncludesLettersThenReturnFalseForIDCheck(){
        String input = "123r56";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidID(input);
        Assertions.assertEquals(expected,actual);
    }
}
