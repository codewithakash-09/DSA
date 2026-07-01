class NumMatrix {

    // prefix[i][j] stores sum of rectangle
    // from (0,0) to (i-1, j-1)
    int[][] prefix;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Extra row and column filled with 0
        // This helps us avoid if conditions
        prefix = new int[m + 1][n + 1];

        // Build the prefix sum matrix
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                /*
                 * Current cell value:
                 * matrix[i-1][j-1]
                 *
                 * Formula:
                 * current value
                 * + top area
                 * + left area
                 * - overlap area
                 */
                prefix[i][j] =
                        matrix[i - 1][j - 1]
                      + prefix[i - 1][j]      // top
                      + prefix[i][j - 1]      // left
                      - prefix[i - 1][j - 1]; // overlap
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        /*
         * Convert matrix coordinates to prefix coordinates
         * by adding 1.
         */

        row1++;
        col1++;
        row2++;
        col2++;

        /*
         * Rectangle Sum Formula:
         *
         * total
         * - upper part
         * - left part
         * + overlap
         */
        return prefix[row2][col2]
             - prefix[row1 - 1][col2]
             - prefix[row2][col1 - 1]
             + prefix[row1 - 1][col1 - 1];
    }
}