package demo.datastructure.datastructure2;

/**
 * ����һ����������ṹ
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8  -> 9
 */
public class ListDemo {
    public static void main(String[] args) {
        //��������
        ListNode listNodeTmp = new ListNode(-1);
        ListNode listNodeStart = listNodeTmp;
        for (int i = 1; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            listNodeTmp.next = listNode;
            listNodeTmp = listNode;
        }

        //��ӡ����
        ListNode listNodeQuery = listNodeStart.next;  //listNodeQuery�൱��ָ�룬ָ���ĸ��ڵ�
        StringBuilder stringBuilder = null;
        while(listNodeQuery !=null){  //ָ��λ���Ƿ�Ϊ��
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(listNodeQuery.val);
            }else{
                stringBuilder.append(" -> "+ listNodeQuery.val);
            }
            listNodeQuery = listNodeQuery.next;    // ָ����һ���ڵ�
        }
        System.out.println(stringBuilder.toString());
    }
}
