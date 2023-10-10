package designpattern.decoration;

public class Lemon extends Condiment{

    private Beverage beverage;

    public Lemon(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 加柠檬";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2;
    }
}
