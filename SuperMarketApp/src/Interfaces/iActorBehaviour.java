package Interfaces;

import Classes.Actor;

public interface iActorBehaviour {
    public boolean isTakeOrder();
    public boolean isMakeOrder();
    public boolean setTakeOrder(boolean take);
    public void setMakeOrder(boolean make);
    Actor getActor();

    /**
     * @apiNote Установить признак, что была проблема во время получения товара и товар не был получен.
     * @param broken
     */
    public void setBrokenOrder(boolean broken);

    /**
     * @apiNote Проверить признак, что была проблема во время получения товара и товар не был получен.
     * @return true, если товар не получен из-за каких-либо проблем.
     */
    public boolean isBrokenOrder();
}
