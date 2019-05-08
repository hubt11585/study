package demo.design.AbstractFactory.imp;

import demo.design.AbstractFactory.abs.Shaobing;

public class HZShaobingStore {

    public Shaobing createShaobing(String type) {
        Shaobing shaobing = null;
        if("greens".equals(type)){
            shaobing = new GreensShaoBing();
            shaobing.prepare();
        }

        return shaobing;
    }
}
