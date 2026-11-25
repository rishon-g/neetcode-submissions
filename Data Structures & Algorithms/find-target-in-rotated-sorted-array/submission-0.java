// Key idea: In a rotated sorted array with unique elements, at least one half (left or right of mid) is always sorted.
// 1. Check if the left half is sorted via nums[mid] >= nums[left] (>= handles the 2-element case where mid == left, otherwise we return -1).
// 2. If target falls within the sorted half's bounds, shrink to that half; otherwise, search the other half.
//    - Left sorted:  if (nums[left] <= target && target < nums[mid]) -> right = mid - 1, else left = mid + 1
//    - Right sorted: if (nums[mid] < target && target <= nums[right]) -> left = mid + 1, else right = mid - 1
// Time complexity: O(log n) | Space complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;


            // by checking nums[mid] here, our comparisons with target will not include it (< vs <=)
            if (nums[mid] == target) {
                return mid;
            }

            // left half is sorted
            // 
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid -1;
                }
                else {
                    left = mid + 1;
                }

            }

            // right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid -1;
                }
            }
        }


        return -1;
        
    }
    
}
