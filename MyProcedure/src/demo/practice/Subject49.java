package demo.practice;

/**
 * ������49��
 * ���������ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ�������ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢һλ���֡�
 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
 * �����Լ���������� 0 ֮�⣬���������������� 0��ͷ��
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
     * ���������
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode  addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;   //��λ
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


