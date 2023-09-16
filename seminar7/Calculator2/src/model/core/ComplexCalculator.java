package model.core;

import model.interfaces.iCalculator;
import model.interfaces.iResult;

public class ComplexCalculator implements iCalculator {

    private ComplexResult result;

    public ComplexCalculator() {
        result = new ComplexResult();
    }

    @Override
    public iCalculator sum(iResult arg) {
        result.realValue += ((ComplexResult) arg).realValue;
        result.imgValue += ((ComplexResult) arg).imgValue;
        return this;
    }

    @Override
    public iCalculator multi(iResult arg) {
        int real = result.realValue * ((ComplexResult) arg).realValue - result.imgValue * ((ComplexResult) arg).imgValue;
        int img = result.realValue * ((ComplexResult) arg).imgValue + result.imgValue * ((ComplexResult) arg).realValue;
        result.realValue = real;
        result.imgValue = img;
        return this;
    }

    @Override
    public iCalculator devide(iResult arg) {
        int real = (int) ((result.realValue * ((ComplexResult) arg).realValue + result.imgValue * ((ComplexResult) arg).imgValue)
                        / (Math.pow(((ComplexResult) arg).realValue, 2) + Math.pow(((ComplexResult) arg).imgValue, 2)));
        int img = (int) ((result.imgValue * ((ComplexResult) arg).realValue - result.realValue * ((ComplexResult) arg).imgValue)
                        / (Math.pow(((ComplexResult) arg).realValue, 2) + Math.pow(((ComplexResult) arg).imgValue, 2)));
        result.realValue = real;
        result.imgValue = img;

        return this;
    }

    @Override
    public void reset() {
        result = new ComplexResult();
    }

    @Override
    public iResult getResult() {
        return result;
    }

    @Override
    public iResult getNewArgument() {
        return new ComplexResult();
    }
}
