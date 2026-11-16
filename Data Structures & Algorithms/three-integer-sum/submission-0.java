// key idea: we first sort the array
// after sorting, we do some checks (if nums[i] > 0, its impossible to make a sum of 0), and also if we have i > 0 && nums[i] == nums[i-1], theres no point in checking the same number twice.

// after doing these checks, we get nums[i] and try to find a sum of 0 by adding nums[left] and nums[right] to nums[i]. if we find a match, we add an array of these values to our result.
// after we find a match, we increment left and  decrement right, essentially seeing if the inner values can add up to nums[i]. to ensure no duplicates, we do an additional while loop on our left value until it is unique, so we are guaranteed to a new array of values if we find a match.

// we do this for every i in the array, checking if every nums[i] has a corresponding nums[left] and nums[right] that adds to 0; and then checking if inner values can give us our nums[i] by incrementing right and decrement left. finally, we return our result

// time complexity: O(n^2)
// space complexity: O(1)


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int left = i +1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                }

                else if (sum < 0) {
                    left++;
                }

                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }

            
        }

        return result;
        
    }
}
