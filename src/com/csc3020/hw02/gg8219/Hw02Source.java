package com.csc3020.hw02.gg8219;

//Ashraf Uddin

public class Hw02Source {

    public static void main(String[] args) {

        ///Define Your instances MathEquation
        MathEquation equations[]=new MathEquation[4];
        equations[0] = new MathEquation('a');
        equations[1] = new MathEquation('s');
        equations[2] = new MathEquation('m');
        equations[3] = new MathEquation('d');

        for(int i=0;i<equations.length;i++) {
            equations[i].execute();
        }
    }
}
