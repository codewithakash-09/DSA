class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int k = s1.length();
        int n = s2.length();

        if (k > n) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Build frequency arrays
        for (int i = 0; i < k; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (isEqual(freq1, freq2)) {
            return true;
        }

        // Slide the window
        for (int i = k; i < n; i++) {

            // Add new character
            freq2[s2.charAt(i) - 'a']++;

            // Remove leftmost character
            freq2[s2.charAt(i - k) - 'a']--;

            if (isEqual(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    public boolean isEqual(int[] freq1, int[] freq2) {

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}