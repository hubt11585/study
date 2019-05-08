package demo.design.visitor.visitor.imp;

import demo.design.visitor.visitor.inf.Visitor;

public class VisitorB implements Visitor {
    /**
     * ��Ӧ��NodeA�ķ��ʲ���
     */
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operationA());
    }
    /**
     * ��Ӧ��NodeB�ķ��ʲ���
     */
    @Override
    public void visit(NodeB node) {
        System.out.println(node.operationB());
    }
}
