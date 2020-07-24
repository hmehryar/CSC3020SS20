package com.csc3020.hw05.go5621;
//*
// Author: Patricia Liu
// Homework 5: Divider
// */
public class Divider extends CalculateBase{
    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() throws Exception{
        if (rightVal != 0) {
            result = leftVal / rightVal;
        } else {
            throw new Exception("Undefined: division by zero");
        }
    }
}
