package demo.design.template.imp;

import demo.design.template.abs.CarModel;

public class Ocar extends CarModel {
    @Override
    protected void start() {
        System.out.println("�µ�  �޳����� ͻͻͻ!");
    }

    @Override
    protected void stop() {
        System.out.println("�µ�  ͣ�� !  ");
    }

}
