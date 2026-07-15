import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int i = 0;
        int j = 0;
        int idx = 0;

        while (j < n) {

            // Remove all smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }

            // Add current index
            dq.addLast(j);

            // Window not complete
            if (j - i + 1 < k) {
                j++;
            }

            // Window complete
            else {

                // Front always contains maximum
                ans[idx++] = nums[dq.peekFirst()];

                // Remove front if it is leaving the window
                if (dq.peekFirst() == i) {
                    dq.pollFirst();
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}