class Solution {
    public void sortColors(int[] nums) {
        int left = 0;      // Boundary for 0s
        int right = nums.length - 1; // Boundary for 2s
        int cur = 0;

        while (cur <= right) {
            if (nums[cur] == 0) {
                // Swap with left boundary and advance both
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                // Swap with right boundary, but don't advance cur yet
                // because the swapped-in value needs inspection
                swap(nums, cur, right);
                right--;
            } else {
                // nums[cur] == 1, it's in the right place
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}