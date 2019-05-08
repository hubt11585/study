package demo.design.visitor.doublederive.imp;

import demo.design.visitor.doublederive.abs.East;
import demo.design.visitor.doublederive.abs.West;

public class TestDoubleVistor {
    public static void main(String[] args) {
        //组合1
        East east = new SubEast1();
        West west = new SubWest1();
        east.goEast(west);
        //组合2
        east = new SubEast1();
        west = new SubWest2();
        east.goEast(west);
    }
}
