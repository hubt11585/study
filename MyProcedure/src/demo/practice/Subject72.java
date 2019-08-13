package demo.practice;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 * ����һ������ÿk���ڵ�һ����з�ת�����㷵�ط�ת�������
 * k��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * ����ڵ���������k������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
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
     * ����ת
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
