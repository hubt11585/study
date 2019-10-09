package demo.datastructure.datastructure1;

/**
 * ����һ�����ṹ��
 *
 *           ����
 *        |         |
 *    ��÷÷       ����
 *                   |
 *                 ���
 */
public class TreeStructure {
    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode();
        treeNode0.setAge(11);
        treeNode0.setName("����");

        TreeNode treeNode1 = new TreeNode();
        treeNode1.setAge(13);
        treeNode1.setName("��÷÷");

        TreeNode treeNode2 = new TreeNode();
        treeNode2.setAge(15);
        treeNode2.setName("����");

        TreeNode treeNode3 = new TreeNode();
        treeNode3.setAge(15);
        treeNode3.setName("���");

        treeNode0.addTreeNode(treeNode1); //���ڵ�������ӽڵ�
        treeNode0.addTreeNode(treeNode2); //���ڵ�������ӽڵ�

        treeNode2.addTreeNode(treeNode3); //�����ڵ��¹����

        System.out.println(treeNode1);   //��ӡ�ڵ㱾��
        System.out.println(treeNode2.getTreeNode(0));  //��ӡ���ڵ�
        System.out.println(treeNode1.getProTreeNode());  //��ӡ���ӿ�
    }
}