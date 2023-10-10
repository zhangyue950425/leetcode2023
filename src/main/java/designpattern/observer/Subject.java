package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 数据已变更，通知观察者们
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    // 通知观察者们
    public void notifyAllObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
