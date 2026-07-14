class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        long sum = 0;
        long max = 0;

        while (j < nums.length) {

            // Add current element
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Window not yet of size k
            if (j - i + 1 < k) {
                j++;
            }

            // Window size becomes k
            else if (j - i + 1 == k) {

                // Check if all elements are distinct
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }

                // Remove leftmost element
                sum -= nums[i];

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
                j++;
            }
        }

        return max;
    }
}