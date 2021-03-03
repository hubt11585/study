package demo.practice;

/**
 *
 */
public class Subject108 {

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

        ListNode listNode = rotateRight(listNode0, 2000000000);
        System.out.println(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        ListNode listNode;
        int length = getLength(head);
        if(length == 0){
            return head;
        }
        k = k % length;
        ListNode headFront = new ListNode();
        ListNode headAfter = head;
        for (int i = 0; i < length-k; i++){
            headAfter = headAfter.next;
            headFront.next = new ListNode(headAfter.val);
        }

//        listNode = headTmp;
//        while((headTmp1 = headTmp1.next) != null){
//
//        }
//
//
//        for (int i = 0; i < k; i++) {
//            headTmp = rotateRight1(headTmp);
//        }
        return listNode;
    }

    public static ListNode rotateRight1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode headTmp = head;
        ListNode listNode = new ListNode();
        listNode.next = headTmp;
        while(true){
            if(head.next.next == null){
                listNode.val = head.next.val;
                head.next = null;
                break;
            } else {
                head = head.next;
            }
        }
        return listNode;
    }

    /**
     * 获得本链表的长度
     * @return
     * @date 2016-9-28
     * @author shaobn
     */
    public static int getLength(ListNode node){
        int length = 0;
        ListNode tmpNode = node;
        while(tmpNode!=null){
            length++;
            tmpNode = tmpNode.next;
        }
        return length;
    }
}