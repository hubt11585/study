package demo.design.adapter.Method1.imp;

import demo.design.adapter.Method1.inf.Telephone;

public class Videophone extends MobilePhone implements Telephone {
    @Override
    public void currency() {
        this.video();
    }
}
