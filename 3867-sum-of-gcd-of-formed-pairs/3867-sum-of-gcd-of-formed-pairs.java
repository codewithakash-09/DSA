class Solution {

    public long gcdSum(int[] nums) {

        int n = nums.length;
        int[] prefixGcd = new int[n];

        int mx = 0;

        // Step 1: Build prefixGcd array
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        // Step 2: Sort the array
        Arrays.sort(prefixGcd);

        // Step 3: Pair smallest with largest
        long ans = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;
    }

    // Euclid's Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}