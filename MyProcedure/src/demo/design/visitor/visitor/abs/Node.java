package demo.design.visitor.visitor.abs;

import demo.design.visitor.visitor.inf.Visitor;

public abstract class Node {
    /**
     * ���ܲ���
     */
    public abstract void accept(Visitor visitor);
}
