package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class AuDi implements Car {
    @Override
    public void Prepare() {
        System.out.println("���ǰµϳ������ڽ�������׼��");
    }

    @Override
    public void Install() {
        System.out.println("���ǰµϳ������ڽ�����װ");
    }

    @Override
    public void Color() {
        System.out.println("���ǰµϳ������ڽ�����ɫ");
    }
}
