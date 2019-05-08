package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.intf.Vegetable;

public class BambooShoots implements Vegetable {

    public BambooShoots(){
        System.out.println("´´½¨ÖñËñ");
    }
    @Override
    public String getName() {
        return "ÖñËñ";
    }
}
