package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.intf.Flour;

public class Wheatmeal implements Flour {
    public Wheatmeal(){
        System.out.println("����С���");
    }
    @Override
    public String getName() {
        return "С���";
    }
}
