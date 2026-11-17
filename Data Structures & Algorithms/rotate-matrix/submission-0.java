class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // step 1: we first transpose (rows become cols, cols become rows)

        // 1 2 3        1 4 7
        // 4 5 6    =   2 5 8
        // 7 8 9        3 6 9
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // step 2: reverse each row

        // 1 4 7        7 4 1
        // 2 5 8    =   8 5 2
        // 3 6 9        9 6 3
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        
    }
}
