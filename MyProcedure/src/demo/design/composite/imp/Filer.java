package demo.design.composite.imp;

import demo.design.composite.abs.Node;
/**
 * ʵ���ļ��ڵ�
 */
public  class Filer extends Node {
    //ͨ��������Ϊ�ļ��ڵ�����
    public Filer(String name) {
        super(name);
    }
    //��ʾ�ļ��ڵ�
    @Override
    public void display() {
        System.out.println(name);
    }
}
