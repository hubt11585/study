package demo.design.AbstractFactory.intf;

public interface IngredientFactory {
    public Flour createFlour();
    public Vegetable createVegetable(String name);
    public Meat createMeat();
    public Seafood createSeafood();
}
