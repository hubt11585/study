package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.abs.Shaobing;
import demo.design.AbstractFactory.intf.IngredientFactory;

public class GreensShaoBing extends Shaobing {
    //ԭ���� ���󹤳�
    IngredientFactory ingredientFactory;
    public GreensShaoBing(){
        ingredientFactory = new ShaobingIngredientFactory();
    }
    @Override
    public void prepare() {
        System.out.println("����ձ���ʼ׼��ԭ����");
        ingredientFactory.createFlour();
        ingredientFactory.createVegetable("����");
        ingredientFactory.createVegetable("���");
    }
}
