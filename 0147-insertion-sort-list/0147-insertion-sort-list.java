class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);

        while (head != null) {

            ListNode current = head;
            head = head.next;

            ListNode prev = dummy;

            while (prev.next != null &&
                    prev.next.val < current.val) {

                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;
        }

        return dummy.next;
    }
}