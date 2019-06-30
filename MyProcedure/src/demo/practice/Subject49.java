package demo.practice;

/**
 * 【程序49】
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class Subject49 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        addTwoNumbers(l1,l2);
    }

    /**
     * 链表输出和
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode  addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;   //进位
        ListNode newListNode = new ListNode(0);
        ListNode tmpListNode ;
        tmpListNode = newListNode;
        while(true){
            ListNode listNode = new ListNode(0);
            int tmp = l1.val + l2.val + carry;
            if(tmp < 10){
                listNode.val = tmp;
                carry = 0;
            }else{
                listNode.val = tmp%10;
                carry = 1;
            }
            tmpListNode.next = listNode;
            tmpListNode = listNode;
            if(l1.next ==null && l2.next == null &&carry == 0){
                break;
            }
            if(l1.next != null){
                l1 = l1.next;
            }else{
                l1 = new ListNode(0);
            }
            if( l2.next != null){
                l2 = l2.next;
            }else{
                l2 = new ListNode(0);
            }
        }
        return newListNode.next;
    }
}


