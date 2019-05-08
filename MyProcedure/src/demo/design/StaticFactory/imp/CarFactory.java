package demo.design.StaticFactory.imp;

import demo.design.StaticFactory.intf.Car;

public class CarFactory {
    //��̬��������������ȱ�������CarFactory���̳У�getCar���ܱ���д��
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
