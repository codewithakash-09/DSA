import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> inter = new HashSet<>();

        // Store nums1
        for (int num : nums1) {
            inter.add(num);
        }

        // Store common elements
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums2) {
            if (inter.contains(num)) {
                result.add(num);
            }
        }

        // Convert HashSet to int[]
        int[] ans = new int[result.size()];

        int i = 0;

        for (int num : result) {
            ans[i] = num;
            i++;
        }

        return ans;
    }
}