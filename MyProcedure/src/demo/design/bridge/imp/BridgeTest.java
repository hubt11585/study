package demo.design.bridge.imp;

import demo.design.bridge.abs.Local;

public class BridgeTest {

    public static void main(String[] args) {
        Local local = new LocalA();   //�����������
        local.road = new LeadToLocalC();  //�����������
        local.fromLocal();
        local.road.leadToLocal();
    }
}
