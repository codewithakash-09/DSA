class Solution {
    public int findKthPositive(int[] arr, int k) {

        int start = 0;
        int end = arr.length;

        while (start < end) {

            int mid = start + (end - start) / 2;

            int missingBeforeMid = arr[mid] - (mid + 1);

            if (missingBeforeMid < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start + k;
    }
}