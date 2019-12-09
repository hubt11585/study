package demo.practice;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * ����һ������(��������)��ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
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
        while(listNode !=null){  //ָ��λ���Ƿ�Ϊ��
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(listNode.val);
            }else{
                stringBuilder.append(" -> "+ listNode.val);
            }
            listNode = listNode.next;    // ָ����һ���ڵ�
        }
        System.out.println(stringBuilder.toString());
    }

    //��������
    public static ListNode listNodeTmp;

    /**
     * ɾ������N�Ľڵ�
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
     * �ݹ��ȡ�ڵ�λ��
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
