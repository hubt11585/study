package demo.design.bridge.imp;

import demo.design.bridge.inf.Road;

public class LeadToLocalA implements Road {
    @Override
    public void leadToLocal() {
        System.out.println("通向上海！");
    }
}
