
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        int n = nums1.length;
        int maxDiff = 0;
        long total = 0;
        long k = (long) k1 + k2;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }

        if (k >= total) {
            return 0;
        }

        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            long count = freq[d];

            if (count == 0) {
                continue;
            }

            long move = Math.min(k, count);

            freq[d] -= (int) move;
            freq[d - 1] += (int) move;
            k -= move;
        }

        // If operations remain, continue reducing the
        // largest differences by processing lower levels.
        // The loop above processes each level only once,
        // so use the remaining-operation handling below.

        long answer = 0;

        for (int d = 1; d < freq.length; d++) {
            answer += (long) d * d * freq[d];
        }

        return answer;
    }
}
