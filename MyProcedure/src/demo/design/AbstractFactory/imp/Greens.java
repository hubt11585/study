package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.intf.Vegetable;

public class Greens implements Vegetable {

    public Greens(){
        System.out.println("�������");
    }
    @Override
    public String getName() {
        return "���";
    }
}
