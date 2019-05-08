package demo.design.composite.imp;

import demo.design.composite.abs.Node;

import java.util.ArrayList;
import java.util.List;

public class Noder extends Node {
    List<Node> nodeList = new ArrayList<Node>();//�ڲ��ڵ��б������ļ����¼�Ŀ¼��
    //ͨ��������Ϊ��ǰĿ¼�ڵ㸳��
    public Noder(String name) {
        super(name);
    }
    //�����ڵ�
    public void addNode(Node node) throws Exception{
        nodeList.add(node);
    }
    //�ݹ�ѭ����ʾ�¼��ڵ�
    @Override
    public void display() {
        System.out.println(name);
        for(Node node:nodeList){
            node.display();
        }
    }
}
