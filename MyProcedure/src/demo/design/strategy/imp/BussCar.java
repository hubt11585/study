package demo.design.strategy.imp;

public class BussCar extends Car {
    public BussCar(String name, String color) {
        super(name, color);
    }

    public void run() {
        System.out.println(color +" " + name  +"ÔÚ»ºÂýµÄÐÐÊ»¡£¡£¡£");
    }
}
