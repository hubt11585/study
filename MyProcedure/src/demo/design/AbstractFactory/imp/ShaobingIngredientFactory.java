package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.intf.*;

public class ShaobingIngredientFactory implements IngredientFactory {
    @Override
    public Flour createFlour() {
        return new Wheatmeal();
    }

    @Override
    public Vegetable createVegetable(String name) {
        if("ÖñËñ".equals(name)){
            return new BambooShoots();
        }
        if("Çà²Ë".equals(name)){
            return new Greens();
        }
        return null;
    }

    @Override
    public Meat createMeat() {
        return null;
    }

    @Override
    public Seafood createSeafood() {
        return null;
    }
}
