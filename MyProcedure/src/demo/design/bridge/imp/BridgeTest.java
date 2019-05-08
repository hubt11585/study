package demo.design.bridge.imp;

import demo.design.bridge.abs.Local;

public class BridgeTest {

    public static void main(String[] args) {
        Local local = new LocalA();   //可以自由组合
        local.road = new LeadToLocalC();  //可以自由组合
        local.fromLocal();
        local.road.leadToLocal();
    }
}
