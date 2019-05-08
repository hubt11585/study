package demo.design.decorator.imp;

import demo.design.decorator.abs.Decorator;

public class ManDecoratorB extends Decorator{

    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB¿‡");
    }
}
