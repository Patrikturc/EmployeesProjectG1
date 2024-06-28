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

    @Test
    void givenStringIfNumbersPresentReturnFalseForIsValidName() {
        String input = "43asg432";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidPartialName(input);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringIfNoNumbersPresentReturnTrueForIsValidName() {
        String input = "jerry";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidPartialName(input);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringLessThanEightReturnFalseForIsValidDate(){
        String input = "jerry";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidDates(input,input);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringOneLessThanEightReturnFalseForIsValidDate(){
        String input = "jerry";
        String input2 = "testingst";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringOneMoreThanTenReturnFalseForIsValidDate(){
        String input = "Velociraptor";
        String input2 = "testingst";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatYYYYMMDDReturnFalse(){
        String input = "2005/10/21";
        String input2 = "2007/10/21";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatMMhyDDhyYYYYReturnFalse(){
        String input = "11-14-2004";
        String input2 = "12-10-2006";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatMMDDYYYYReturnFalseIfDateInvalid(){
        String input = "13/31/2004";
        String input2 = "05/10/2006";
        boolean expected = false;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatMMDDYYYYReturnTrueIfValid(){
        String input = "12/31/2004";
        String input2 = "05/10/2006";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatMDDYYYYReturnTrueIfValid(){
        String input = "1/31/2004";
        String input2 = "3/10/2006";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatMDYYYYReturnTrueIfValid(){
        String input = "1/1/2004";
        String input2 = "3/1/2006";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDateInFormatMMDYYYYReturnTrueIfValid(){
        String input = "10/1/2004";
        String input2 = "03/1/2006";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenStringWithDatesInDifferentFormatsReturnTrueIfValid(){
        String input = "1/1/2004";
        String input2 = "03/12/2006";
        boolean expected = true;
        boolean actual = FieldChecks.hasValidDates(input,input2);
        Assertions.assertEquals(expected, actual);
    }
}
