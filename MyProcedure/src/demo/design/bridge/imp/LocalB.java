package demo.design.bridge.imp;

import demo.design.bridge.abs.Local;

public class LocalB extends Local {
    @Override
    public void fromLocal() {
        System.out.println("从西安出发！");
    }
}
