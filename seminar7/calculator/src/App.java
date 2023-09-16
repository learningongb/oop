import Model.Core.Calculator;
import Model.Interfaces.iCalculable;
import View.ViewCalculator;

public class App {
    public static void main(String[] args) throws Exception {
        iCalculable calculator = new Calculator(0);


//       iCalculable decorator = new Decorator(new Calculator(0), new Logger());


        ViewCalculator view = new ViewCalculator(calculator);
        view.run();
        //System.out.println("Hello, World!");
    }
}
