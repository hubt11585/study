package demo.practice;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 */
public class Subject71 {

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
        ListNode tmp = swapPairs(listNode0);

        StringBuilder stringBuilder = null;
        while(tmp !=null){  //ָ��λ���Ƿ�Ϊ��
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(tmp.val);
            }else{
                stringBuilder.append(" -> "+ tmp.val);
            }
            tmp = tmp.next;    // ָ����һ���ڵ�
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * ������������λ��
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode resultHead = newHead;
        while(head != null){
            ListNode tmp0 = new ListNode(head.val);
            ListNode tmp1 = null;
            if(head.next != null){
                tmp1 = new ListNode(head.next.val);
                newHead.next = tmp1;
                tmp1.next = tmp0;
                head = head.next.next;
            }else{
                newHead.next = tmp0;
                head = null;
            }
            newHead = tmp0;

        }
        return resultHead.next;
    }
}
