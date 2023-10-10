package designpattern.proxy;

public class FoodServiceProxy implements FoodService{

    private FoodService foodService = new FoodServiceImpl();
    @Override
    public Food makeChicken() {
        System.out.println("我们马上要开始制作鸡肉了");
        Food food = foodService.makeChicken();
        System.out.println("鸡肉制作完成啦，加点胡椒粉");
        food.addCondiment("pepper");
        return food;
    }

    @Override
    public Food makeNoodle() {
        System.out.println("准备制作拉面~");
        Food food = foodService.makeNoodle();
        System.out.println("制作完成啦");
        return food;
    }
}
