package demo.design.decorator.imp;

import demo.design.decorator.abs.Decorator;

public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA¿‡");
    }

    public void reEat() {
        System.out.println("‘Ÿ≥‘“ª∂Ÿ∑π");
    }
}
