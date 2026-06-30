class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int minheight=0;
        int maxarea=0;
        int crr=0;
        while(left<right){
            int width=right-left;
         minheight=Math.min(height[left],height[right]);
            crr=width*minheight;
            maxarea=Math.max(crr,maxarea);
            if(height[left]<height[right]){
                    left++;
            }else{
                right--;
            }
        }return maxarea;
    }
}