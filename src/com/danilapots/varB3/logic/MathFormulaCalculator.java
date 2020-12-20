package com.danilapots.varB3.logic;

public class MathFormulaCalculator {

    public Double calculate(int formulaIndex, Double x, Double y, Double z) {
        switch (formulaIndex) {
            case 1:
                return calculateFirst(x,y,z);
            case 2:
                return calculateSecond(x,y,z);
            default:
                throw new IllegalArgumentException("Unknown formula index");
        }
    }

    private Double calculateFirst(Double x, Double y, Double z) {
        double sinResult = Math.sin(Math.log(y) + Math.sin(Math.PI * y * y));
        double squareResult = Math.pow((x*x + Math.sin(z) + Math.pow(Math.E, Math.cos(z))), 0.25);
        return sinResult * squareResult;
    }

    private Double calculateSecond(Double x, Double y, Double z) {
        double fractionResult = (1 + Math.pow(x,z) + Math.log(y * y)) / (Math.pow(x * x * x + 1, 0.5));
        double nextResult = 1 - Math.sin(y * z);
        return fractionResult * nextResult;
    }
}
