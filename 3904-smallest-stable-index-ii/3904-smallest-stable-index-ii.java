class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }
        int maxi = nums[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);

            if (maxi - rightMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}