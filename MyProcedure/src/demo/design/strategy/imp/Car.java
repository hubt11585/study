package demo.design.strategy.imp;

import demo.design.strategy.inf.CarFunction;

/**
 *
 * @ClassName   : Car
 * @Description : ÿ���������е���ͬ�����Ժ���Ϊ
 *
 */
public class Car implements CarFunction {
    protected String name;            //������
    protected String color;            //����ɫ
    private CarFunction carFunction;//������

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color +" " + name  +"����ʻ������");
    }
}
