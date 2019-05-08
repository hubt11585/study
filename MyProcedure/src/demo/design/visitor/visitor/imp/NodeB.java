package demo.design.visitor.visitor.imp;

import demo.design.visitor.visitor.abs.Node;
import demo.design.visitor.visitor.inf.Visitor;

public class NodeB extends Node {
    /**
     * ���ܷ���
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeB���еķ���
     */
    public String operationB(){
        return "NodeB";
    }
}
