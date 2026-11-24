// key idea: run binary search, keeping note of where the middle number is.
// if nums[mid] > nums[right], this means the middle number is large and there is a drop off coming, or in otherwords, the min number. Make left = mid + 1 (so we focus on right half)
// if nums[mid] < nums[right], this means the middle number is probably in the right order, so the min number is on the left somewhere. reduce right to be mid. (so we focus on left half)

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // the middle is bigger than the end, meaning there is a drop (and thus, the min) is coming

            // e.g. [4, 5, 6, 1, 2, 3]
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // the middle is less than the end, meaning the min is probably on the left
            /// e.g. [1, 2, 3, 4, 5, 6]
            else {
                right = mid;

            }
        }

        // left and right meet; 
        return nums[left];
    }
}
