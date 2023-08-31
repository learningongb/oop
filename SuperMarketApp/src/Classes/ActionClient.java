package Classes;

import Interfaces.iActorBehaviour;

/**
 * @apiNote
 */
public class ActionClient extends Actor {
    private static String action;
    private int id;
    private static int maxActionCount;
    private static int actionCount;
    private static int currentId;

    static {
        currentId = 0;
        actionCount = 0;
        maxActionCount = 0;
    }
    /**
     * @apiNote Set action name
     * @param action action name
     */
    public static  void setAction(String action) {
        ActionClient.action = action;
    }

    /**
     * @apiNote Returns action name
     * @return
     */
    public static String getAction() {
        return ActionClient.action;
    }

    /**
     * @apiNote Set maximum count of action clients
     * @param newMaxActionCount count of action clients
     */
    public static void setMaxActionCount(int newMaxActionCount) {
        ActionClient.maxActionCount = newMaxActionCount;
    }

    /**
     * @apiNote Количество покупателей, обслуженных по акции
     * @return
     */
    public static int getActionCount() {
        return actionCount;
    }

    public ActionClient(String name) {
        super(name);
        this.id = ++currentId;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public void setTakeOrder(boolean take) {
        ActionClient.actionCount++;
        super.isTakeOrder = take;
    }

    @Override
    public void setMakeOrder(boolean make) {
        super.isMakeOrder = make;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    /**
     * @apiNote Return order after take order
     */
    @Override
    public void returnOrder() {
        super.returnOrder();
        actionCount--;
    }
}
