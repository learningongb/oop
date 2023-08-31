package Classes;

import Interfaces.iActorBehaviour;

public class TaxInspector implements iActorBehaviour {

    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
   

    public TaxInspector() {
        this.name = "Tax audit";
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean setTakeOrder(boolean take) {
        isTakeOrder=take;
        return true;
    }

    @Override
    public void setMakeOrder(boolean make) {
        isMakeOrder = make;
    }

    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }

    @Override
    public void setBrokenOrder(boolean broken) {

    }

    @Override
    public boolean isBrokenOrder() {
        return false;
    }

}
