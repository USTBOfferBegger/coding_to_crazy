class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)return head;
        ListNode reverse = null,p = head;
        while(p!=null && p.next!=null){
            reverse = p.next;
            p.next = p.next.next;
            reverse.next = head;
            head = reverse;
        }
        return head;
    }
}
