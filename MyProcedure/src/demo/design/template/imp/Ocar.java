package demo.design.template.imp;

import demo.design.template.abs.CarModel;

public class Ocar extends CarModel {
    @Override
    protected void start() {
        System.out.println("°ÂµÏ  ÎÞ³×Æô¶¯ Í»Í»Í»!");
    }

    @Override
    protected void stop() {
        System.out.println("°ÂµÏ  Í£³µ !  ");
    }

}
