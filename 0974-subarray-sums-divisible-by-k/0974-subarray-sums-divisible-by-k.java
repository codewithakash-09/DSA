class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        // remainder -> frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix sum has remainder 0
        // This helps count subarrays starting from index 0
        map.put(0, 1);

        int prefixSum = 0;
        int answer = 0;

        for (int num : nums) {

            // Update running sum
            prefixSum += num;

            // Compute remainder
            int rem = prefixSum % k;

            // Java can produce negative remainders
            // Example: -1 % 5 = -1
            // Convert it to a positive remainder
            if (rem < 0) {
                rem += k;
            }

            /*
             * If we've seen this remainder before,
             * then every previous occurrence forms
             * a subarray whose sum is divisible by k.
             */
            answer += map.getOrDefault(rem, 0);

            // Store the current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return answer;
    }
}