package csc3020.hw05.gn8271;
// Homework 05
// Author: Raisa Zaman

public class Adder extends CalculateBase {

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public void calculate() {
        setResult(getLeftVal() + getRightVal());
    }

}
