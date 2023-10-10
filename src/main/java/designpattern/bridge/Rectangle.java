package designpattern.bridge;

public class Rectangle extends Shape{
    private int x;
    private int y;

    public Rectangle(int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }
    @Override
    protected void draw() {
        drawAPI.draw(0, x, y);
    }
}
