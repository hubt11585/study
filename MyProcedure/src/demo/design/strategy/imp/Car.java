package demo.design.strategy.imp;

import demo.design.strategy.inf.CarFunction;

/**
 *
 * @ClassName   : Car
 * @Description : 每个车都具有的相同的属性和行为
 *
 */
public class Car implements CarFunction {
    protected String name;            //车名字
    protected String color;            //车颜色
    private CarFunction carFunction;//策略类

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color +" " + name  +"在行驶。。。");
    }
}
