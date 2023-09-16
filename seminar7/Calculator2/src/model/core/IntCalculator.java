package model.core;

import model.interfaces.iCalculator;
import model.interfaces.iResult;

public class IntCalculator implements iCalculator {
    private IntResult result;

    public IntCalculator() {
        this.result = new IntResult();
    }

    @Override
    public iCalculator sum(iResult arg) {
        result.value += ((IntResult) arg).value;
        return this;
    }

    @Override
    public iCalculator multi(iResult arg) {
        result.value *= ((IntResult) arg).value;
        return this;
    }

    @Override
    public iCalculator devide(iResult arg) {
        result.value /= ((IntResult) arg).value;
        return this;
    }

    @Override
    public void reset() {
        result = new IntResult();
    }

    @Override
    public iResult getResult() {
        return result;
    }

    @Override
    public iResult getNewArgument() {
        return new IntResult();
    }
}
