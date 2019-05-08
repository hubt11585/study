package demo.design.Builder.imp;

import demo.design.Builder.intf.IBuilder;

public class BuilderEconomics implements IBuilder {

    House house = null;

    public BuilderEconomics(House house){
        this.house = house;
    }

    @Override
    public void createArea() {
        house.setArea(89);            //这些属性值并未用到，这里只是起到方便理解作用，就假定认为已经用到了这些属性。
        System.out.println("平民房就89平米哦！");
    }

    @Override
    public void createSleeping() {
        house.setSleeping(3);
        System.out.println("平民房就3个卧室哦！");
    }

    @Override
    public void createCarNum() {
        house.setCarNum(1);
        System.out.println("平民房就1个车库哦！");
    }

    @Override
    public void createToliet() {
        house.setToliet(2);
        System.out.println("平民房就1个厕所哦！");
    }

    @Override
    public House createHouse() {
        System.out.println("建造一个平民房！");
        this.createArea();
        this.createCarNum();
        this.createSleeping();
        this.createToliet();
        return house;
    }
}
