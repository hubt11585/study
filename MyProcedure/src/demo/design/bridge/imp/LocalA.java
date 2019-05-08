package demo.design.bridge.imp;

import demo.design.bridge.abs.Local;

public class LocalA extends Local{
    @Override
    public void fromLocal() {
        System.out.println("从杭州出发！");
    }
}
