import Fabric.GemGenerator;
import Fabric.GoldGenerator;
import Fabric.ItemGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {

        Random rnd = ThreadLocalRandom.current();

        List<ItemGenerator> generatorList = new ArrayList<>();
        generatorList.add(new GoldGenerator());
        generatorList.add(new GemGenerator());

        for (int i = 0; i < 10; i++) {
            int index = Math.abs(rnd.nextInt(2));
            generatorList.get(index).openReward();
        }

    }
}
