package demo.design.Builder.imp;

import demo.design.Builder.intf.IBuilder;

public class BuilderEconomics implements IBuilder {

    House house = null;

    public BuilderEconomics(House house){
        this.house = house;
    }

    @Override
    public void createArea() {
        house.setArea(89);            //��Щ����ֵ��δ�õ�������ֻ���𵽷���������ã��ͼٶ���Ϊ�Ѿ��õ�����Щ���ԡ�
        System.out.println("ƽ�񷿾�89ƽ��Ŷ��");
    }

    @Override
    public void createSleeping() {
        house.setSleeping(3);
        System.out.println("ƽ�񷿾�3������Ŷ��");
    }

    @Override
    public void createCarNum() {
        house.setCarNum(1);
        System.out.println("ƽ�񷿾�1������Ŷ��");
    }

    @Override
    public void createToliet() {
        house.setToliet(2);
        System.out.println("ƽ�񷿾�1������Ŷ��");
    }

    @Override
    public House createHouse() {
        System.out.println("����һ��ƽ�񷿣�");
        this.createArea();
        this.createCarNum();
        this.createSleeping();
        this.createToliet();
        return house;
    }
}
