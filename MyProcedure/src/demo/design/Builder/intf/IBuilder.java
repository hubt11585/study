package demo.design.Builder.intf;

import demo.design.Builder.imp.House;

public interface IBuilder {

    public void createArea();

    public void createSleeping();

    public void createCarNum();

    public void createToliet();

    public House createHouse();
}
