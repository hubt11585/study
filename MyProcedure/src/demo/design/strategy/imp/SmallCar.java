package demo.design.strategy.imp;

/**
 *
 * @ClassName   : SmallCar
 * @Description : �������ʵ������
 *
 */
public class SmallCar extends Car {
    public SmallCar(String name, String color) {
        super(name, color);
    }

    public void run() {
        System.out.println(color +" " + name  +"�ڸ��ٵ���ʻ������");
    }
}
