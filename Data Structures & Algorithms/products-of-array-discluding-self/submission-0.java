// key idea: every number in the array is the product of the left
// and right numbers in the array.

// for example, if we have nums = [1, 2, 4, 6]
// left = [1, 1, 2, 8]
// right = [48, 24, 6, 1]

// then, we multiply (remember, the product of the left and right
// numbers is gonna be the products of the array except self)

// output = [48, 24, 12, 8]

// time complexity: O(n) (we iterate over 3n arrays)
// space complexity: O(n) (we create 3n arrays)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        int[] right = new int[n];
        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}  
