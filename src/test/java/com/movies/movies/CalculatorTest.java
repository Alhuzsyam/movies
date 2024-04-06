package com.movies.movies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.movies.Calculator;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    
    @Test
    public void testaddsuccess(){
       var result = calculator.add(10, 20);
       assertEquals(result, 30);
    }
}
