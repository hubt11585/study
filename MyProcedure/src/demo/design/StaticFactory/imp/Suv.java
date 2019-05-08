package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class Suv implements Car {
    @Override
    public void Prepare() {
        System.out.println("����SUV�������ڽ�������׼��");
    }

    @Override
    public void Install() {
        System.out.println("����SUV�������ڽ�����װ");
    }

    @Override
    public void Color() {
        System.out.println("����SUV�������ڽ�����ɫ");
    }
}
