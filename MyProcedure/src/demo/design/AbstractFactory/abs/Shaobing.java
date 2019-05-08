package demo.design.AbstractFactory.abs;

import demo.design.AbstractFactory.intf.Flour;
import demo.design.AbstractFactory.intf.Vegetable;

public abstract class Shaobing {
    public String name;  //�ձ�������
    public Vegetable greens; //���
    public Vegetable bambooShoots; //����
    public Flour wheatMeal; //С���

    public abstract void prepare();
    //���ձ�
    public void bake(){
        System.out.println("Bake for 25 minutes at 350C");
    }

    //������
    public void cut(){
        System.out.println("Cutting the dough into fit slices");
    }
    //���
    public void box(){
        System.out.println("Place shaobing into official box");
    }
}
