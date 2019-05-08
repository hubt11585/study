package demo.design.composite.imp;

import demo.design.composite.abs.Node;

import java.util.ArrayList;
import java.util.List;

public class Noder extends Node {
    List<Node> nodeList = new ArrayList<Node>();//内部节点列表（包括文件和下级目录）
    //通过构造器为当前目录节点赋名
    public Noder(String name) {
        super(name);
    }
    //新增节点
    public void addNode(Node node) throws Exception{
        nodeList.add(node);
    }
    //递归循环显示下级节点
    @Override
    public void display() {
        System.out.println(name);
        for(Node node:nodeList){
            node.display();
        }
    }
}
