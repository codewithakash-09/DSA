class Solution {
      public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length-1;

    while (left < right) {

        int sum = numbers[left]+numbers[right];

        if (sum == target) {
            return new int[]{left+1, right+1};   // remember: 1-based indices
        }
        else if (sum < target) {
            // move which pointer?
            left++;
        }
        else {
            // move which pointer?
            right--;
        }
    }

    return new int[]{-1, -1};
}
}