package cn.rainshell.myleetcode.mergeTwoSortedLists;

/**
 * @author jason
 * @date 2020/7/29
 */
public class MergeTwoSortedLists {

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 时间复杂度O（n+m），空间复杂度O（1）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2  = l2.next;
            }
            pre = pre.next;
        }
        pre.next =  l1 == null ? l2 :  l1;
        return preHead.next;
    }
}
