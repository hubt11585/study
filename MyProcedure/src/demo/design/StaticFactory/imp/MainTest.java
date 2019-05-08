package demo.design.StaticFactory.imp;

public class MainTest {
    public static void main(String[] args){
        Manager manager=new Manager();
        manager.CreatCar("audi");
        manager.CreatCar("baoma");
        manager.CreatCar("suv");
    }
}
