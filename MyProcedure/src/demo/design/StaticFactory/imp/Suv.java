package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class Suv implements Car {
    @Override
    public void Prepare() {
        System.out.println("我是SUV车，我在进行生产准备");
    }

    @Override
    public void Install() {
        System.out.println("我是SUV车，我在进行组装");
    }

    @Override
    public void Color() {
        System.out.println("我是SUV车，我在进行着色");
    }
}
