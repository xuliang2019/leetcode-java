class SortList {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);

    }
    public ListNode getMid(ListNode head){
        ListNode fast, slow;
        fast =head;
        slow = null;
        while(fast!=null && fast.next!=null){
            slow = (slow == null)? fast: slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null; // split linkedList to two parts
        return mid;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null? l2:l1;
        return dummy.next;

    }
}