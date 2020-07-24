package csc3020.hw05.go3480;

public class Subtractor extends CalculateBase {
    public Subtractor(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    void calculate() {
        setResult(getLeftVal() - getRightVal());
    }
}
