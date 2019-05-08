package demo.design.Builder.imp;

import demo.design.Builder.intf.IBuilder;

public class Test {

    public static void main(String[] args){
        House house = new House();
        //普通房
        IBuilder iBuilder1=new BuilderEconomics(house);
        Director director1=new Director(iBuilder1);
        director1.build();

        System.out.println("");
        // 土豪房
        IBuilder iBuilder2=new BuilderLuxury(house);
        Director director2=new Director(iBuilder2);
        director2.build();
    }
}
