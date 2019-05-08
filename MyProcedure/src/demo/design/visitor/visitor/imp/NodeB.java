package demo.design.visitor.visitor.imp;

import demo.design.visitor.visitor.abs.Node;
import demo.design.visitor.visitor.inf.Visitor;

public class NodeB extends Node {
    /**
     * 接受方法
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeB特有的方法
     */
    public String operationB(){
        return "NodeB";
    }
}
