package demo.practice;

public class Subject68 {
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

        ListNode listNode01 = new ListNode(5);
        ListNode listNode11 = new ListNode(7);
        listNode01.next = listNode11;

        ListNode tmp = mergeTwoLists(listNode3,listNode01);
        System.out.println(tmp);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode resulttmp = result;
        ListNode tmp1 = l1;
        while (tmp1 != null){
            ListNode tmpVal = new ListNode(tmp1.val);
            if(l2 == null){
                resulttmp.next = tmpVal;
                resulttmp = tmpVal;
                tmp1 = tmp1.next;
                continue;
            }
            while (l2 != null) {
                if(tmpVal.val <= l2.val){
                    resulttmp.next = tmpVal;
                    resulttmp = tmpVal;
                    if(tmp1 != null){
                        tmp1 = tmp1.next;
                        break;
                    }else{
                        ListNode tmp3 = new ListNode(l2.val);
                        resulttmp.next = new ListNode(l2.val);
                        resulttmp.next = tmp3;
                        resulttmp = tmp3;
                        l2 = l2.next;
                    }
                }else{
                    ListNode tmp3 = new ListNode(l2.val);
                    resulttmp.next = new ListNode(l2.val);
                    resulttmp.next = tmp3;
                    resulttmp = tmp3;
                    l2 = l2.next;
                }
            }
        }
        if (l2 != null) {
            resulttmp.next = l2;
        }
        return result.next;
    }
}
