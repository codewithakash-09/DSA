class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int j = 0;
        int[] freq = new int[26];
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k < p.length(); k++) {
            freq[p.charAt(k) - 'a']++;
        }
        int count = 0;

        for (int k = 0; k < 26; k++) {
            if (freq[k] > 0)
                count++;
        }
        while (j < s.length()) {
            freq[s.charAt(j) - 'a']--;

            if (freq[s.charAt(j) - 'a'] == 0)
                count--;

            if ((j - i + 1) < p.length()) {
                j++;
            } else if ((j - i + 1) == p.length()) {
                if (count == 0) ans.add(i);
                freq[s.charAt(i) - 'a']++;

                if (freq[s.charAt(i) - 'a'] == 1) count++;
                i++;
                j++;
            }
        }
        return ans;
    }
}