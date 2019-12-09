package demo.practice;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
 * ����һ������ÿk���ڵ�һ����з�ת�����㷵�ط�ת�������
 * k��һ��������������ֵС�ڻ��������ĳ��ȡ�
 * ����ڵ���������k������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 */
public class Subject72 {

    public ListNode head5 = new ListNode(0);
    public ListNode head4 = head5;

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
        ListNode listNode5 = new Subject72().reverseKGroup(listNode0,2);
        StringBuilder stringBuilder = null;
        while(listNode5 !=null){  //ָ��λ���Ƿ�Ϊ��
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(listNode5.val);
            }else{
                stringBuilder.append(" -> "+ listNode5.val);
            }
            listNode5 = listNode5.next;    // ָ����һ���ڵ�
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * ����K����
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode head0 = head;
        ListNode head1 = head;
        ListNode head2 = null;
        for (int i = 0; i < k-1; i++) {
            if(head0 != null){
                head0 = head0.next;
            }else{
                break;
            }
        }
        if(head0 != null){
            head2 = head0.next;
            head0.next = null;
        }else{
            head5.next = head;
            return head4.next;
        }
        ListNode head3 = reverseGroup(head);
        head5.next = head3;
        head5 = head3;
        while(head5.next != null){
            head5 = head5.next;
        }
        reverseKGroup(head2,k);
        return head4.next;
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
