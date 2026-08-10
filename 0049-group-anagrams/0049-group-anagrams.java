import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] freq = new int[26];

            // Count characters
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                freq[ch - 'a']++;
            }

            // Convert frequency array into a String key
            String key = Arrays.toString(freq);

            // Create list if key doesn't exist
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add word to its anagram group
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}