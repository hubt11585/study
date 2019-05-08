package demo.design.visitor.visitor.imp;

import demo.design.visitor.visitor.abs.Node;
import demo.design.visitor.visitor.inf.Visitor;

public class NodeA extends Node {
    /**
     * ���ܲ���
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA���еķ���
     */
    public String operationA(){
        return "NodeA";
    }
}
