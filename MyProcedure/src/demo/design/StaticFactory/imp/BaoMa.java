package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class BaoMa implements Car {
    @Override
    public void Prepare() {
        System.out.println("���Ǳ��������ڽ�������׼��");
    }

    @Override
    public void Install() {
        System.out.println("���Ǳ��������ڽ�����װ");
    }

    @Override
    public void Color() {
        System.out.println("���Ǳ��������ڽ�����ɫ");
    }
}
