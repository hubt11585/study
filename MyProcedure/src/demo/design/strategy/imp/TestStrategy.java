package demo.design.strategy.imp;

/**
 *
 * @ClassName   : Strategy
 * @Description : 运行环境类:Strategy
 * @date        : 2017年12月9日 上午11:43:58
 *
 */
public class TestStrategy {
    public static void main(String[] args) {
        Car smallCar = new SmallCar("路虎","黑色");
        Car bussCar = new BussCar("公交车","白色");
        Person p1 = new Person("小明", 20);
        p1.driver(smallCar);
        p1.driver(bussCar);
    }
}
