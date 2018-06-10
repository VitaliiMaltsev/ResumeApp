package com.company.model;

import com.company.storage.WebAppExeption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calc = new Calculator();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void abs() {
        Assertions.assertThrows(WebAppExeption.class, () ->
            Assertions.assertEquals(6, calc.abs(-6)));

    }
}