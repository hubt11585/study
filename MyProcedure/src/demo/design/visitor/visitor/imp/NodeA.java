package demo.design.visitor.visitor.imp;

import demo.design.visitor.visitor.abs.Node;
import demo.design.visitor.visitor.inf.Visitor;

public class NodeA extends Node {
    /**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA(){
        return "NodeA";
    }
}
