package demo.design.strategy.imp;

/**
 *
 * @ClassName   : Strategy
 * @Description : ���л�����:Strategy
 * @date        : 2017��12��9�� ����11:43:58
 *
 */
public class TestStrategy {
    public static void main(String[] args) {
        Car smallCar = new SmallCar("·��","��ɫ");
        Car bussCar = new BussCar("������","��ɫ");
        Person p1 = new Person("С��", 20);
        p1.driver(smallCar);
        p1.driver(bussCar);
    }
}
