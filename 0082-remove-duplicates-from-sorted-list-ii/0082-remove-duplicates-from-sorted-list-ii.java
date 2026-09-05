class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Check whether current is part of a duplicate group
            if (current.next != null && current.val == current.next.val) {

                // Skip all nodes having the same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }

                // Remove the entire duplicate group
                prev.next = current.next;

            } else {
                // Current is unique, so move prev forward
                prev = prev.next;
            }

            // Move current forward
            current = current.next;
        }

        return dummy.next;
    }
}

