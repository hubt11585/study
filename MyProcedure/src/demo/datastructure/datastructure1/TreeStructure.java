package demo.datastructure.datastructure1;

/**
 * 创建一个树结构：
 *
 *           李磊
 *        |         |
 *    韩梅梅       丽丽
 *                   |
 *                 李刚
 */
public class TreeStructure {
    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode();
        treeNode0.setAge(11);
        treeNode0.setName("李磊");

        TreeNode treeNode1 = new TreeNode();
        treeNode1.setAge(13);
        treeNode1.setName("韩梅梅");

        TreeNode treeNode2 = new TreeNode();
        treeNode2.setAge(15);
        treeNode2.setName("莉莉");

        TreeNode treeNode3 = new TreeNode();
        treeNode3.setAge(15);
        treeNode3.setName("李刚");

        treeNode0.addTreeNode(treeNode1); //父节点关联孩子节点
        treeNode0.addTreeNode(treeNode2); //父节点关联孩子节点

        treeNode2.addTreeNode(treeNode3); //丽丽节点下挂李刚

        System.out.println(treeNode1);   //打印节点本身
        System.out.println(treeNode2.getTreeNode(0));  //打印树节点
        System.out.println(treeNode1.getProTreeNode());  //打印父接口
    }
}