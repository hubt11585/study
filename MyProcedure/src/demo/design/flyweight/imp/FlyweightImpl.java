package demo.design.flyweight.imp;

import demo.design.flyweight.inf.Flyweight;

public class FlyweightImpl implements Flyweight {
    @Override
    public void action(int arg) {
        System.out.println("²ÎÊýÖµ: " + arg);
    }
}
