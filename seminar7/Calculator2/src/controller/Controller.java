package controller;

import model.CalculatorWithEvent;
import model.CalculatorWithLogger;
import model.EventLogger;
import model.Logger;
import model.core.ComplexCalculator;
import view.View;

public class Controller {
    public void run() {
        View view;
        /** Чтобы использовать обычный целочисленный калькулятор, раскомментируйте код */
//        View view = new View(new IntCalculator());
//        view.run();
        /** Чтобы использовать комплексный целочисленный калькулятор, раскомментируйте код */
//        view = new View(new ComplexCalculator());
//        view.run();
        /** Чтобы использовать комплексный целочисленный калькулятор c логированием через Decorator, раскомментируйте код */
//        view = new View(new CalculatorWithLogger(new ComplexCalculator(), new Logger()));
//        view.run();
        /** Чтобы использовать комплексный целочисленный калькулятор c логированием через Observer, раскомментируйте код */
        CalculatorWithEvent calc = new CalculatorWithEvent(new ComplexCalculator());
        calc.addObserver(new EventLogger());
        view = new View(calc);
        view.run();
    }
}
