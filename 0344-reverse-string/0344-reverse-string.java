////this question is solved using recursion
class Solution {
    public void reverseString(char[] s) {
        int j = s.length - 1;
        swap(s, 0, j);
    }

    private void swap(char[] s, int l, int r) {
        if (l >= r) {
            return;
        }

        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;

        swap(s, l + 1, r - 1);
    }
}