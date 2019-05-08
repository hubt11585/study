package demo.design.visitor.doublederive.imp;

import demo.design.visitor.doublederive.abs.East;
import demo.design.visitor.doublederive.abs.West;

public class SubEast2 extends East {
    @Override
    public void goEast(West west) {
        west.goWest2(this);
    }

    public String myName2(){
        return "SubEast2";
    }
}
