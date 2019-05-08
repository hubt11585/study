package demo.design.strategy.imp;

/**
 *
 * @ClassName   : SmallCar
 * @Description : 具体策略实现子类
 *
 */
public class SmallCar extends Car {
    public SmallCar(String name, String color) {
        super(name, color);
    }

    public void run() {
        System.out.println(color +" " + name  +"在高速的行驶。。。");
    }
}
