class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int rd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[rd] != nums[i]) {
                rd++;
                nums[rd] = nums[i];
            }
        }
        return rd + 1;
    }
}