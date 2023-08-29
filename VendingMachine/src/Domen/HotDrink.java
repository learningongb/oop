package Domen;

public class HotDrink extends Product{
    private int temp;

    public HotDrink(String name, int price, int temp) {
        super(name, price);
        this.temp = temp;
    }

    @Override
    public String toString() {
        return super.toString() + "; temp=" + temp;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", температура: " + this.temp;
    }
}
