package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class Manager {
    Car car = null;
    public Car CreatCar(String type){
        car = CarFactory.getCarInstance(type);//��̬����������Ҫʹ�ô�������CarFactory����������ֱ��ʹ��CarFactory�������䷽����
        car.Prepare();
        car.Install();
        car.Color();
        return car;
    }
}
