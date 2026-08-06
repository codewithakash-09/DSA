class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        int left = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            long required = (long) nums[right] * (right - left + 1);

            while (required - sum > k) {
                sum -= nums[left];
                left++;

                required = (long) nums[right] * (right - left + 1);
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}