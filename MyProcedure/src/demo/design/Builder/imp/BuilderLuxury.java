package demo.design.Builder.imp;

import demo.design.Builder.intf.IBuilder;

public class BuilderLuxury implements IBuilder {

    House house = null;

    public BuilderLuxury(House house){
        this.house = house;
    }

    @Override
    public void createArea() {
        house.setArea(500);
        System.out.println("ƽ�񷿾�500ƽ��Ŷ��");
    }

    @Override
    public void createSleeping() {
        house.setSleeping(10);
        System.out.println("ƽ�񷿾�10������Ŷ��");
    }

    @Override
    public void createCarNum() {
        house.setCarNum(6);
        System.out.println("ƽ�񷿾�6������Ŷ��");
    }

    @Override
    public void createToliet() {
        house.setToliet(10);
        System.out.println("ƽ�񷿾�10������Ŷ��");
    }

    @Override
    public House createHouse() {
        System.out.println("����һ����������");
        this.createArea();
        this.createCarNum();
        this.createSleeping();
        this.createToliet();
        return house;
    }
}
