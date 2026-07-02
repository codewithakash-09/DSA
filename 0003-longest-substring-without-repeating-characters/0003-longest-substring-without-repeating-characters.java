class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        // Expand the window
        for (int right = 0; right < s.length(); right++) {

            // Current character
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {

                left = map.get(currentChar) + 1;
            }
            // Store the latest position of the character
            map.put(currentChar, right);

            // Current window length
            int currentLength = right - left + 1;

            // Update answer
            ans = Math.max(ans, currentLength);
        }

        return ans;
    }
}