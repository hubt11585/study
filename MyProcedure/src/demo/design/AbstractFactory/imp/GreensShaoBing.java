package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.abs.Shaobing;
import demo.design.AbstractFactory.intf.IngredientFactory;

public class GreensShaoBing extends Shaobing {
    //原材料 抽象工厂
    IngredientFactory ingredientFactory;
    public GreensShaoBing(){
        ingredientFactory = new ShaobingIngredientFactory();
    }
    @Override
    public void prepare() {
        System.out.println("洋葱烧饼开始准备原材料");
        ingredientFactory.createFlour();
        ingredientFactory.createVegetable("竹笋");
        ingredientFactory.createVegetable("青菜");
    }
}
