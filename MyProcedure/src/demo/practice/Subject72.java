package demo.practice;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class Subject72 {

    public static ListNode head1 = null;

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(-9);
        ListNode listNode4 = new ListNode(3);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 =  reverseGroup(listNode0);
        System.out.println(listNode5);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode head0 = head;
        for (int i = 0; i < k; i++) {
            if(head0 != null){
                head0 = head0.next;
            }else{
                head0 = head;
                break;
            }
        }

        head = head0;
        reverseKGroup(head,k);

        return null;
    }

    /**
     * 链表反转
     * @param head0
     * @return
     */
    public static ListNode reverseGroup(ListNode head0) {
        if(head0==null||head0.next==null){
            return head0;
        }
        ListNode nowHead = reverseGroup(head0.next);
        head0.next.next=head0;
        head0.next=null;
        return nowHead;
    }
}
