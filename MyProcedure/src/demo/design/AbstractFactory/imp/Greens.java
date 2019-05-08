package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.intf.Vegetable;

public class Greens implements Vegetable {

    public Greens(){
        System.out.println("创建青菜");
    }
    @Override
    public String getName() {
        return "青菜";
    }
}
