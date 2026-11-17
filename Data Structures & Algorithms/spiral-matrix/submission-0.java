class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int left = 0;

        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                result.add(matrix[top][c]);
            }
            top++;

            for (int c = top; c <= bottom; c++) {
                result.add(matrix[c][right]);
            }
            right--;

            if (top > bottom || left > right) {
                break;
            }

            for (int c = right; c >= left; c--) {
                result.add(matrix[bottom][c]);
            }
            bottom--;

            for (int c = bottom; c >= top; c--) {
                result.add(matrix[c][left]);
            }
            left++;

        }

        return result;
        
    }
}
