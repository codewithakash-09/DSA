class Solution {
    public int getDecimalValue(ListNode head) {

        int ans = 0;
        ListNode temp = head;

        while (temp != null) {
            ans = ans * 2 + temp.val;
            temp = temp.next;
        }

        return ans;
    }
}