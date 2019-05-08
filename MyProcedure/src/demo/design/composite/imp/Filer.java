package demo.design.composite.imp;

import demo.design.composite.abs.Node;
/**
 * 实现文件节点
 */
public  class Filer extends Node {
    //通过构造器为文件节点命名
    public Filer(String name) {
        super(name);
    }
    //显示文件节点
    @Override
    public void display() {
        System.out.println(name);
    }
}
