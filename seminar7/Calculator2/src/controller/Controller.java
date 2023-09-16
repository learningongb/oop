package controller;

import model.core.ComplexCalculator;
import model.core.IntCalculator;
import view.View;

public class Controller {
    public void run() {
        View view;
        /** Чтобы использовать обычный целочисленный калькулятор, раскомментируйте код */
//        View view = new View(new IntCalculator());
//        view.run();
        /** Чтобы использовать комплексный целочисленный калькулятор, раскомментируйте код */
        view = new View(new ComplexCalculator());
        view.run();
    }
}
