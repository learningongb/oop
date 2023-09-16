package model.interfaces;

public interface iCalculator {
    iCalculator sum(iResult arg);
    iCalculator multi(iResult arg);
    iCalculator devide(iResult arg);
    void reset();
    iResult getResult();
    iResult getNewArgument();
}
