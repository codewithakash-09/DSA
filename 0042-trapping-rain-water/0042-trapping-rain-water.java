class Solution {

    public int trap(int[] height) {

        // Pointer at the beginning
        int left = 0;

        // Pointer at the end
        int right = height.length - 1;

        // Maximum wall seen so far from the left
        int leftMax = 0;

        // Maximum wall seen so far from the right
        int rightMax = 0;

        // Stores the final answer
        int totalWater = 0;


        // Continue until both pointers meet
        while (left < right) {

            // Process the side with the smaller height
            if (height[left] < height[right]) {

                // If current bar is taller than leftMax,
                // update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {

                    // Water trapped at this index
                    totalWater += leftMax - height[left];
                }

                // Move to the next position
                left++;

            } else {

                // If current bar is taller than rightMax,
                // update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {

                    // Water trapped at this index
                    totalWater += rightMax - height[right];
                }

                // Move inward from the right
                right--;
            }
        }

        return totalWater;
    }
}