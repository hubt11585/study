package demo.datastructure.datastructure2;

/**
 * ����һ��˫��������ṹ(1 ָ�� 2 ��ͬʱ2 Ҳָ�� 1)
 * 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
 */
public class DoubleListDemo {
    public static void main(String[] args) {
        //��������
        DoubleListNode doubleListNodeTmp = new DoubleListNode(-1);
        DoubleListNode doubleListNodeStart = doubleListNodeTmp;
        for (int i = 1; i < 10; i++) {
            DoubleListNode doubleListNode = new DoubleListNode(i);
            doubleListNodeTmp.next = doubleListNode;
            doubleListNode.pro = doubleListNodeTmp;
            doubleListNodeTmp = doubleListNode;
        }

        DoubleListNode doubleListNodeQuery = doubleListNodeStart.next.next.next;   //ָ��3��λ��
        //��ȡ����
        System.out.println("�ڵ�����"+doubleListNodeQuery.val);
        //��ȡ��һ���ڵ�.
        System.out.println("��һ���ڵ㣺"+doubleListNodeQuery.pro.val);
        //��ȡ��һ���ڵ�.
        System.out.println("��һ���ڵ㣺"+doubleListNodeQuery.next.val);
    }
}
