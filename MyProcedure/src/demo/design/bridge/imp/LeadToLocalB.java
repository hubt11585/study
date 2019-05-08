package demo.design.bridge.imp;

import demo.design.bridge.inf.Road;

public class LeadToLocalB implements Road {
    @Override
    public void leadToLocal() {
        System.out.println("通向北京！");
    }
}
