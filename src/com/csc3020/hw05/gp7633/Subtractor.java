package csc3020.hw05.gp7633;

public class Subtractor extends CalculateBase {
    private double leftValue;
    private double rightValue;
    double result;

    Subtractor(double lVal, double rVal) {
        super(lVal, rVal);
        leftValue = lVal;
        rightValue = rVal;
    }

    @Override
    void calculate() {
        result = leftValue - rightValue;
    }

    @Override
    public double getResult() {
        return result;
    }
}
