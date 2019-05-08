package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.intf.Flour;

public class Wheatmeal implements Flour {
    public Wheatmeal(){
        System.out.println("创建小麦粉");
    }
    @Override
    public String getName() {
        return "小麦粉";
    }
}
