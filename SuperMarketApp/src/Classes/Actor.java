package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;

public abstract class Actor implements iActorBehaviour, iReturnOrder {

    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected boolean isReturned;
    protected boolean isBrokenOrder;

    @Override
    public void setBrokenOrder(boolean broken) {
        this.isBrokenOrder = broken;
    }

    @Override
    public boolean isBrokenOrder() {
        return this.isBrokenOrder;
    }

    public Actor(String name) {
        this.name = name;
    }

    abstract public void setName(String name);
    abstract public String getName();

    /**
     * @apiNote Вернуть ранее полученный товар.
     * При этом снимается признак выдачи товара и устанавливается признак возврата.
     */
    @Override
    public void returnOrder() {
        this.isReturned = true;
        this.isTakeOrder = false;
    }

    /**
     * @apiNote Получить признак, что клиент ранее вернул товар
     * @return true, если клиент вернул товар
     */
    @Override
    public boolean isReturnOrder() {
        return this.isReturned;
    }
}
