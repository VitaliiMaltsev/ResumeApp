package com.company.model;

import com.company.storage.WebAppExeption;

public class Calculator {
    public int abs(int value){
        if (value<-5) throw new WebAppExeption("MMMMMMMM");
        return Math.abs(value);
    }
}
