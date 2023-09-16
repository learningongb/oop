import meteo.AdapterST500Info;
import meteo.MS200;
import meteo.MeteoSensor;
import meteo.MeteoStore;
import meteo.ST500Info;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        MeteoStore meteoDB = new MeteoStore();

        MeteoSensor oldSensor = new MS200(1);
        meteoDB.save(oldSensor);

        meteoDB.save(new AdapterST500Info(new ST500Info().getData()));
    }
}
