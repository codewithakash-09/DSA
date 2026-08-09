import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }

                // Row
                if (rows[i].contains(ch)) {
                    return false;
                }
                rows[i].add(ch);

                // Column
                if (cols[j].contains(ch)) {
                    return false;
                }
                cols[j].add(ch);

                // Box
                int box = (i / 3) * 3 + (j / 3);

                if (boxes[box].contains(ch)) {
                    return false;
                }
                boxes[box].add(ch);
            }
        }

        return true;
    }
}