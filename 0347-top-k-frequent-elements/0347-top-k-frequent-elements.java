
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map entries into a list
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Step 3: Sort by frequency, highest first
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Store the top k numbers
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}