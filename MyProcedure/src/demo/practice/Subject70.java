package demo.practice;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class Subject70 {
    public static void main(String[] args) {

        ListNode listNode0 = new ListNode(-10);
        ListNode listNode1 = new ListNode(-9);
        ListNode listNode2 = new ListNode(-9);
        ListNode listNode3 = new ListNode(-3);
        ListNode listNode4 = new ListNode(-1);
        ListNode listNode5 = new ListNode(-1);
        ListNode listNode6 = new ListNode(0);

        listNode1.next = listNode0;
        listNode2.next = listNode1;
        listNode3.next = listNode2;
        listNode4.next = listNode3;
        listNode5.next = listNode4;
        listNode6.next = listNode5;

        ListNode listNode01 = new ListNode(-5);
        ListNode listNode02 = new ListNode(4);
        ListNode listNode03 = new ListNode(-8);


        ListNode listNode11 = null;

        ListNode listNode20 = new ListNode(-9);
        ListNode listNode21 = new ListNode(-6);
        ListNode listNode22 = new ListNode(-5);
        ListNode listNode23 = new ListNode(-4);
        ListNode listNode24 = new ListNode(-2);
        ListNode listNode25 = new ListNode(2);
        ListNode listNode26 = new ListNode(3);

        listNode21.next = listNode20;
        listNode22.next = listNode21;
        listNode23.next = listNode22;
        listNode24.next = listNode23;
        listNode25.next = listNode24;
        listNode26.next = listNode25;

        ListNode listNode30 = new ListNode(-3);
        ListNode listNode31 = new ListNode(-3);
        ListNode listNode32 = new ListNode(-2);
        ListNode listNode33 = new ListNode(-1);
        ListNode listNode34 = new ListNode(0);

        listNode31.next = listNode30;
        listNode32.next = listNode31;
        listNode33.next = listNode32;
        listNode34.next = listNode33;

        ListNode[] arr = new ListNode[]{listNode6,listNode01,listNode02,listNode03,listNode11,listNode26,listNode34};
        ListNode tmp= mergeKLists(arr);
        StringBuilder stringBuilder = null;
        while(tmp !=null){  //指向位置是否为空
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                stringBuilder.append(tmp.val);
            }else{
                stringBuilder.append(" -> "+ tmp.val);
            }
            tmp = tmp.next;    // 指向下一个节点
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     *  合并链表
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode[] arr = mergeKLists0(lists);
        return arr[0];
    }

    /**
     * 使用合并算法，组合链表
     * @param lists
     * @return
     */
    public static ListNode[] mergeKLists0(ListNode[] lists) {
        int length = lists.length;
        if(length == 1){
            return lists;
        }
        ListNode[] listTmp = new ListNode[(int)Math.ceil(length/2.0)];
        ListNode[] listTmp0 =  null;
        for (int i = 0 ,j = 0; i < length; i = i+2 , j++) {
            ListNode tmp0 = null;
            if(i+1 <= length-1){
                tmp0 = mergeTwoLists(lists[i],lists[i+1]);
            }else{
                tmp0 = mergeTwoLists(lists[i],null);
            }
            listTmp[j] = tmp0;
        }
        listTmp0 = mergeKLists0(listTmp);
        return listTmp0;
    }

    /**
     * 递归实现链表插入
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
