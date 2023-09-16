package view;

import model.interfaces.iCalculator;
import model.interfaces.iResult;

import java.util.Scanner;

public class View {

    private iCalculator calculator;

    public View(iCalculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            calculator.reset();
            iResult primaryArg = calculator.getNewArgument().promptArgument("Введите первый аргумент");
            calculator.sum(primaryArg);
            while (true) {
                String cmd = prompt("Введите команду (*, +, /, =) : ");
                if (cmd.equals("=")) {
                    iResult result = calculator.getResult();
                    System.out.printf("Результат %s\n", result.getResultString());
                    break;
                }
                iResult arg = calculator.getNewArgument().promptArgument("Введите второй аргумент");
                if (cmd.equals("*")) {
                    calculator.multi(arg);
                } else if (cmd.equals("+")) {
                    calculator.sum(arg);
                } else if (cmd.equals("/")) {
                    calculator.devide(arg);
                } else {
                    System.out.println("Неизвестная команда");
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
