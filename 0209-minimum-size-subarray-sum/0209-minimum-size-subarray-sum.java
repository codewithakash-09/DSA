class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength=Integer.MAX_VALUE;
        int sum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
        while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];//we decrease the sum value by subtracting left value from it
                left++;
            }
        } if (minLength == Integer.MAX_VALUE) {//if we can't find the minimum value of min length we retrun 0;
            return 0;
            } else {
               return minLength;
            }
    }
}