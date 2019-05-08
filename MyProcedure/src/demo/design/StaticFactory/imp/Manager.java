package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class Manager {
    Car car = null;
    public Car CreatCar(String type){
        car = CarFactory.getCarInstance(type);//静态方法，不需要使用创建工厂CarFactory来创建对象，直接使用CarFactory来调用其方法。
        car.Prepare();
        car.Install();
        car.Color();
        return car;
    }
}
