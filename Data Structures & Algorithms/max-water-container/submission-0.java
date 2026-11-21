class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length -1;
        int best = 0;

        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int area = h * (r - l);

            if (area > best) {
                best = area;
            }

            if (heights[l] < heights[r]) {
                l++;
            }

            else {
                r--;
            }

            
        }

        return best;
        
    }
}
