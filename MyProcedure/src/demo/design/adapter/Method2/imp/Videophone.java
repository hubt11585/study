package demo.design.adapter.Method2.imp;

import demo.design.adapter.Method1.inf.Telephone;

public class Videophone implements Telephone {

    MobilePhone mobilePhone = null;

    public Videophone(MobilePhone mobilePhone){
        this.mobilePhone = mobilePhone;
    }


    @Override
    public void currency() {
        mobilePhone.video();
    }
}
