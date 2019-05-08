package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class CarFactory {
    //静态方法，这样做的缺点是如果CarFactory被继承，getCar不能被重写。
    public static Car getCarInstance(String type){
        Car carInstance = null;
        if(type.equals("audi")){
            carInstance=new AuDi();
        }else if(type.equals("baoma")){
            carInstance=new BaoMa();
        }else if(type.equals("suv")){
            carInstance=new Suv();
        }
        return carInstance;
    }
}
