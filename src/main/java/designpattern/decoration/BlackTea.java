package designpattern.decoration;

public class BlackTea extends Beverage{
    @Override
    public String getDescription() {
        return "红茶";
    }

    @Override
    public double cost() {
        return 10;
    }
}
