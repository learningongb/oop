package Classes;

import java.util.List;
import java.util.ArrayList;

import Interfaces.iActorBehaviour;

import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;

public class Market implements iMarketBehaviour, iQueueBehaviour {

    private List<iActorBehaviour> queue;
    private List<iActorBehaviour> actorsForTestReturn;

    private Logger logger;

    public void addActorForTestReturn(iActorBehaviour actor) {
        actorsForTestReturn.add(actor);
    }

    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
        this.actorsForTestReturn =  new ArrayList<iActorBehaviour>();
        this.logger = new Logger();
    }

    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        logger.append(actor.getActor().getName() + " клиент пришел в магазин ");
        System.out.println(actor.getActor().getName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        logger.append(actor.getActor().getName() + " клиент добавлен в очередь ");
        System.out.println(actor.getActor().getName() + " клиент добавлен в очередь ");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            logger.append(actor.getName() + " клиент ушел из магазина ");
            System.out.println(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }

    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                if (actor.setTakeOrder(true)) {
                    logger.append(actor.getActor().getName() + " клиент получил свой заказ ");
                    System.out.println(actor.getActor().getName() + " клиент получил свой заказ ");
                    if (actorsForTestReturn.contains(actor)) {
                        actor.getActor().returnOrder();
                        logger.append(actor.getActor().getName() + " клиент вернул полученный заказ ");
                        System.out.println(actor.getActor().getName() + " клиент вернул полученный заказ ");
                    }
                } else {
                    actor.setBrokenOrder(true);
                    logger.append(actor.getActor().getName() + " клиент получил отказ в обслуживании", true);
                    System.out.println(actor.getActor().getName() + " клиент получил отказ в обслуживании");
                }
            }
        }

    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder() || actorsForTestReturn.contains(actor) || actor.isBrokenOrder()) {
                releaseActors.add(actor.getActor());
                logger.append(actor.getActor().getName() + " клиент ушел из очереди ");
                System.out.println(actor.getActor().getName() + " клиент ушел из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                logger.append(actor.getActor().getName() + " клиент сделал заказ ");
                System.out.println(actor.getActor().getName() + " клиент сделал заказ ");
            }
        }

    }

}
