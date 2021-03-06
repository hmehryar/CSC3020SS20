package com.csc3020.hw06.go5334;

public class MathEquation {
    double leftValue;
    double rightValue;
    double result;
    char opCode='a';

    private MathEquation(){
    }

    public MathEquation(char opCode) {
        this();
        this.opCode = opCode;
    }
    public MathEquation(char opCode,double leftValue1,double rightValue){
        this(opCode);
        this.leftValue=leftValue1;
        this.rightValue=rightValue;
    }

    public double getResult() {
        return result;
    }

    void execute(int leftValue,int rightValue){
        this.leftValue=leftValue;
        this.rightValue=rightValue;
        execute();
        result=(int)result;
    }
    void execute(double leftValue,double rightValue){
        this.leftValue=leftValue;
        this.rightValue=rightValue;
        execute();
    }
    void execute(){
        switch (opCode){
            case 'a':
                result=leftValue+rightValue;
                break;
            case 's':
                result=leftValue-rightValue;
                break;
            case 'm':
                result=leftValue*rightValue;
                break;
            case 'd':
                if(rightValue==0){
                    System.out.println("Error: right Value for the division function can't equal zero");
                    result = 0.0d;
                    break;
                }
                result=leftValue/rightValue;
                break;
            default:
                System.out.println("Error: Invalid Operation Code");
                result = 0.0d;
                break;
        }
    }
}