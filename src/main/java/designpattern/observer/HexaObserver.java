package designpattern.observer;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String result = Integer.toHexString(subject.getState()).toUpperCase();
        System.out.println("订阅的数据发生变化，新的数据处理为十六进制值为：" + result);
    }

    public static void main(String[] args) {
        Subject subject1 = new Subject();
        new BinaryObserver(subject1);
        new HexaObserver(subject1);
        subject1.setState(11);
    }
}
