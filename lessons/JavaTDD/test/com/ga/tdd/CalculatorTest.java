package com.ga.tdd;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    //    Tests
//    @Test(expected = RuntimeException.class)
//    @DisplayName("When more than 2 numbers are used then exception is thrown")
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//        calculator.add("1,2,3");
//    }

    @Test
    @DisplayName("When 2 Numbers are used then no exception is thrown")
    public final void whenMoreThan2NumbersAreUsedThenNoExceptionIsThrown(){
        calculator.add("2,3");
    }

    @Test(expected = RuntimeException.class)
    @DisplayName("When non number is used then exception is thrown")
    public final void Whennonnumberisusedthenexceptionisthrown(){
        calculator.add("1,x");
    }

    @Test
    @DisplayName("When empty String is used then retrun vallue is 0")
    public final void whenEmptyStringIsUsedThenReturnValueIs0(){
        Assert.assertEquals(0,Calculator.add(""));
    }

    @Test
    @DisplayName("When one number is used then return value is that same number")
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber(){
        Assert.assertEquals(3,Calculator.add("3"));
    }

    @Test
    @DisplayName("When two numbers are used then return value is their sum")
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum(){
        Assert.assertEquals(3+6,Calculator.add("3,6"));
    }

    @Test
    @DisplayName("when any number of numbers is used then return values are their sums")
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3 + 6 + 15 + 18 + 46 + 33, calculator.add("3,6,15,18,46,33"));
    }

}