package demo.design.Builder.imp;

import demo.design.Builder.intf.IBuilder;

public class Director {
    private IBuilder iBuilder;

    public Director(IBuilder iBuilder){
        this.iBuilder = iBuilder;
    }

    public void build(){
        iBuilder.createHouse();
    }
}
