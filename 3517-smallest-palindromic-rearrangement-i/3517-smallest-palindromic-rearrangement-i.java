class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count characters
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();

        // Build the smallest possible left half
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
        }

        // Middle character for odd length
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) ('a' + i));
                break;
            }
        }

        // Right half = reverse of left
        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}