package demo.design.visitor.visitor.inf;

import demo.design.visitor.visitor.imp.NodeA;
import demo.design.visitor.visitor.imp.NodeB;

public interface Visitor {
    /**
     * ��Ӧ��NodeA�ķ��ʲ���
     */
    public void visit(NodeA node);
    /**
     * ��Ӧ��NodeB�ķ��ʲ���
     */
    public void visit(NodeB node);
}
