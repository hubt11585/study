package demo.design.AbstractFactory.abs;

import demo.design.AbstractFactory.intf.Flour;
import demo.design.AbstractFactory.intf.Vegetable;

public abstract class Shaobing {
    public String name;  //烧饼的名字
    public Vegetable greens; //青菜
    public Vegetable bambooShoots; //竹笋
    public Flour wheatMeal; //小麦粉

    public abstract void prepare();
    //烤烧饼
    public void bake(){
        System.out.println("Bake for 25 minutes at 350C");
    }

    //切面团
    public void cut(){
        System.out.println("Cutting the dough into fit slices");
    }
    //打包
    public void box(){
        System.out.println("Place shaobing into official box");
    }
}
