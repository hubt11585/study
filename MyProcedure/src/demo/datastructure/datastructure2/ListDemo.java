package demo.datastructure.datastructure2;

/**
 * 创建一个单向链表结构
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8  -> 9
 */
public class ListDemo {
    public static void main(String[] args) {
        //创建链表
        ListNode listNodeTmp = new ListNode(-1);
        ListNode listNodeStart = listNodeTmp;
        for (int i = 1; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            listNodeTmp.next = listNode;
            listNodeTmp = listNode;
        }

        //打印链表
        ListNode listNodeQuery = listNodeStart.next;  //listNodeQuery相当于指针，指向哪个节点
        StringBuilder stringBuilder = null;
        while(listNodeQuery !=null){  //指向位置是否为空
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(listNodeQuery.val);
            }else{
                stringBuilder.append(" -> "+ listNodeQuery.val);
            }
            listNodeQuery = listNodeQuery.next;    // 指向下一个节点
        }
        System.out.println(stringBuilder.toString());
    }
}
