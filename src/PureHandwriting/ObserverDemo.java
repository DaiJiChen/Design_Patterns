package PureHandwriting;

import java.util.ArrayList;
import java.util.List;
class Observer {
    Subject subject;

    Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void update() {
        System.out.println("Observed change: statu = " + subject.getStatu());
    }
}

class Subject {
    private int statu;
    private List<Observer> observers = new ArrayList<>();

    int getStatu() { return statu;}

    void setStatu(int x) {
        statu = x;
        notifyAllObserver();
    }

    void attach(Observer o) {
        observers.add(o);
    }

    public void notifyAllObserver() {
        for(Observer o : observers) {
            o.update();
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer o1 = new Observer(subject);
        Observer o2 = new Observer(subject);

        subject.setStatu(1);
        subject.setStatu(2);
    }
}




