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
        System.out.println("平民房就500平米哦！");
    }

    @Override
    public void createSleeping() {
        house.setSleeping(10);
        System.out.println("平民房就10个卧室哦！");
    }

    @Override
    public void createCarNum() {
        house.setCarNum(6);
        System.out.println("平民房就6个车库哦！");
    }

    @Override
    public void createToliet() {
        house.setToliet(10);
        System.out.println("平民房就10个厕所哦！");
    }

    @Override
    public House createHouse() {
        System.out.println("建造一个豪华房！");
        this.createArea();
        this.createCarNum();
        this.createSleeping();
        this.createToliet();
        return house;
    }
}
