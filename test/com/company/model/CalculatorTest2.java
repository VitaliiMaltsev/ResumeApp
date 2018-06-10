package com.company.model;

import com.company.storage.WebAppExeption;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest2 {
Calculator calculator = new Calculator();
    @Test(expected = WebAppExeption.class)
    public void abs() {
        Assert.assertEquals(5, calculator.abs(-5));
        throw new WebAppExeption("qqq");
    }
}