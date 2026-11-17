class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int left = 0;
        
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // because we traverse top and right in the previous 2 loops, we need to make sure 
            // they are still in the correct bounds before continuing (otherwise we risk adding
            // the same elements again)
            if (top > bottom || left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;

    }
}
