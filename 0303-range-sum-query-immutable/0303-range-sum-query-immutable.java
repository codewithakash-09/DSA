class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        // If the range starts from index 0
        if (left == 0) {
            return prefix[right];
        }

        // Remove everything before 'left'
        return prefix[right] - prefix[left - 1];
    }
}