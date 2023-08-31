package Classes;

import Interfaces.iActorBehaviour;

/**
 * @apiNote Описывает акционного клиента.
 * Содержит статические свойства
 * action - название акции
 * maxActionCount - максимальное количество покупателей по акции
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
     * @apiNote Установить название акции
     * @param action название акции
     */
    public static void setAction(String action) {
        ActionClient.action = action;
    }

    /**
     * @apiNote Возвращает название акции
     * @return
     */
    public static String getAction() {
        return ActionClient.action;
    }

    /**
     * @apiNote Установить максимальное количество покупателей по акции
     * @param newMaxActionCount максимальное количество
     */
    public static void setMaxActionCount(int newMaxActionCount) {
        ActionClient.maxActionCount = newMaxActionCount;
    }

    /**
     * @apiNote Количество покупателей, получивших товар по акции
     * @return
     */
    public static int getActionCount() {
        return actionCount;
    }

    /**
     * @apiNote Конструктор акционного клиента
     * @param name имя клиента
     */
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

    /**
     * @apiNote Проверяет, получен ли заказ
     * @return true, если заказ получен
     */
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    /**
     * @apiNote Проверяет, сделан ли заказ
     * @return true, если заказ сделан
     */
    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /**
     * @apiNote Устанавливает признак получения заказа с проверкой возможности установки признака.
     * Если количество акционных покупателей превышает условия акции, клиент получает отказ.
     * Если зазаз получен, увеличивается количество клиентов, воспользовавшихся акцией
     * @param take новое значение признака
     * @return true, если новое значение успешно установлено
     */
    @Override
    public boolean setTakeOrder(boolean take) {
        if (take && ActionClient.actionCount >= ActionClient.maxActionCount) {
            return false;
        }
        ActionClient.actionCount++;
        super.isTakeOrder = take;
        return true;
    }

    /**
     * @apiNote Устанавливает признак сделанного заказа
     * @param make новое значение признака
     */
    @Override
    public void setMakeOrder(boolean make) {
        super.isMakeOrder = make;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    /**
     * @apiNote Возвращает товар одновременно уменьшая количество покупателей, воспользовавшихся акцией.
     */
    @Override
    public void returnOrder() {
        super.returnOrder();
        actionCount--;
    }
}
