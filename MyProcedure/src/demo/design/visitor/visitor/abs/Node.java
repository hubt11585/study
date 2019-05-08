package demo.design.visitor.visitor.abs;

import demo.design.visitor.visitor.inf.Visitor;

public abstract class Node {
    /**
     * ½ÓÊÜ²Ù×÷
     */
    public abstract void accept(Visitor visitor);
}
