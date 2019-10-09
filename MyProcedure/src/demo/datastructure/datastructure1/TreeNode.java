package demo.datastructure.datastructure1;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int age;    // �ڵ����ԣ�����
    private String name;   //�ڵ����ԣ�����

    TreeNode proTreeNode;    //�ϼ��ڵ�
    List<TreeNode> list = new ArrayList<TreeNode>(); //���ӽڵ�

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getProTreeNode() {
        return proTreeNode;
    }

    public void setProTreeNode(TreeNode proTreeNode) {
        this.proTreeNode = proTreeNode;
    }

    public void addTreeNode(TreeNode treeNode){
        list.add(treeNode);
        treeNode.proTreeNode = this;
    }

    public TreeNode getTreeNode(Integer i){
        return list.get(i);
    }

    public void removeTreeNode(TreeNode treeNode){
        list.remove(treeNode);
        treeNode.proTreeNode = null;
    }

    public String toString(){
        return "������"+name+";���䣺"+age+"��";
    }
}
