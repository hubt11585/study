package demo.design.visitor.doublederive.imp;

import demo.design.visitor.doublederive.abs.East;
import demo.design.visitor.doublederive.abs.West;

public class SubEast1 extends East {
    @Override
    public void goEast(West west) {
        west.goWest1(this);
    }

    public String myName1(){
        return "SubEast1";
    }
}
