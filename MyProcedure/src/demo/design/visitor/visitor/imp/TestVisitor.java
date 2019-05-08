package demo.design.visitor.visitor.imp;

import demo.design.visitor.visitor.inf.Visitor;

public class TestVisitor {
    public static void main(String[] args) {
        //����һ���ṹ����
        ObjectStructure os = new ObjectStructure();
        //���ṹ����һ���ڵ�
        os.add(new NodeA());
        //���ṹ����һ���ڵ�
        os.add(new NodeB());
        //����һ��������
        Visitor visitor = new VisitorA();
        os.action(visitor);
    }
}
