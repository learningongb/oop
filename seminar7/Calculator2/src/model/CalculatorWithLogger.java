package model;

import model.core.ComplexCalculator;
import model.interfaces.iCalculator;
import model.interfaces.iResult;

public class CalculatorWithLogger implements iCalculator {

    private iCalculator calculator;
    private Logger logger;

    public CalculatorWithLogger(ComplexCalculator calculator, Logger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    @Override
    public iCalculator sum(iResult arg) {
        String before = calculator.getResult().getResultString();
        iCalculator result = calculator.sum(arg);
        logger.write(String.format("%s + %s = %s", before, arg.getResultString(), calculator.getResult().getResultString()));
        return result;
    }

    @Override
    public iCalculator multi(iResult arg) {
        String before = calculator.getResult().getResultString();
        iCalculator result = calculator.multi(arg);
        logger.write(String.format("(%s) * (%s) = (%s)", before, arg.getResultString(), calculator.getResult().getResultString()));
        return result;
    }

    @Override
    public iCalculator devide(iResult arg) {
        String before = calculator.getResult().getResultString();
        iCalculator result = calculator.devide(arg);
        logger.write(String.format("(%s) / (%s) = (%s)", before, arg.getResultString(), calculator.getResult().getResultString()));
        return result;
    }

    @Override
    public void reset() {
        logger.write("Reset калькулятора");
        calculator.reset();
    }

    @Override
    public iResult getResult() {
        return calculator.getResult();
    }

    @Override
    public iResult getNewArgument() {
        return calculator.getNewArgument();
    }
}
