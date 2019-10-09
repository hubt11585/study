package demo.datastructure.datastructure2;

/**
 * 创建一个双向向链表结构(1 指向 2 的同时2 也指向 1)
 * 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
 */
public class DoubleListDemo {
    public static void main(String[] args) {
        //创建链表
        DoubleListNode doubleListNodeTmp = new DoubleListNode(-1);
        DoubleListNode doubleListNodeStart = doubleListNodeTmp;
        for (int i = 1; i < 10; i++) {
            DoubleListNode doubleListNode = new DoubleListNode(i);
            doubleListNodeTmp.next = doubleListNode;
            doubleListNode.pro = doubleListNodeTmp;
            doubleListNodeTmp = doubleListNode;
        }

        DoubleListNode doubleListNodeQuery = doubleListNodeStart.next.next.next;   //指向3的位置
        //获取自身
        System.out.println("节点自身："+doubleListNodeQuery.val);
        //获取上一个节点.
        System.out.println("上一个节点："+doubleListNodeQuery.pro.val);
        //获取下一个节点.
        System.out.println("下一个节点："+doubleListNodeQuery.next.val);
    }
}
