package demo.design.adapter.Method1.imp;

import demo.design.adapter.Method1.inf.Phone;

public class MobilePhone implements Phone {
    @Override
    public void video() {
        System.out.println("手机可以看视频");
    }
}
