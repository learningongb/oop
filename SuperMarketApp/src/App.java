import Classes.*;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        Market magnit = new Market();
        ActionClient.setAction("Второй апельсин в подарок");
        ActionClient.setMaxActionCount(2);

        iActorBehaviour client1 = new OrdinaryClient("boris");
        iActorBehaviour client2 = new SpecialClient("prezident", 1);
        iActorBehaviour client3 = new TaxInspector();
        iActorBehaviour client4 = new ActionClient("Ivan");
        iActorBehaviour client5 = new ActionClient("Sergey");

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);

        magnit.acceptToMarket(client4);
        magnit.acceptToMarket(client5);

        magnit.update();

        System.out.printf("Количество покупателей, обслуженных по акции \"%s\": %d", ActionClient.getAction(), ActionClient.getActionCount());
    }
}
