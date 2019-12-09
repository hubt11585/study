package demo.practice;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 给定一个链表(单项链表)，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Subject66 {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = new Subject66().removeNthFromEnd(listNode0,1);
        StringBuilder stringBuilder = null;
        while(listNode !=null){  //指向位置是否为空
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(listNode.val);
            }else{
                stringBuilder.append(" -> "+ listNode.val);
            }
            listNode = listNode.next;    // 指向下一个节点
        }
        System.out.println(stringBuilder.toString());
    }

    //公共变量
    public static ListNode listNodeTmp;

    /**
     * 删除倒数N的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        listNodeTmp = null;
        if(head == null){
            return head;
        }
        int num = nodeNum(head,n);
        if(num == n){
            return head.next;
        }
        return head;
    }

    /**
     * 递归获取节点位置
     * @param head
     * @param n
     * @return
     */
    public int nodeNum(ListNode head,int n){
        int tmp = 0;
        if(head != null){
            tmp = 1+ nodeNum(head.next,n);
            if(tmp == n +1){
                head.next = listNodeTmp;
            }
            if(tmp == n-1){
                listNodeTmp = head;
            }
        }
        return tmp;
    }
}
