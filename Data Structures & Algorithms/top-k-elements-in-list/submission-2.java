// key idea: we sort by frequency
// first, we count the frequency of each number using a hashmap [1,2,2,2,3,3,3] -> 1=1, 2=3, 3=3

// then we create frequency buckets (n+1), where we swap directions, and each number in our array
// is tied to the amount of times it appears: 1 = [1], 2 = 0, 3 = [2, 3].
// since we use an array list, the frequency is tied to the index as opposed to a hashmap
// where we would have a key and a value (here it is index (freq), value)

// we iterate backwards from the highest frequency bucket down to 1 and grab elements until
// our result array has k numbers.

// Time complexity: O(n)
// Space complexity: O(n)


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        // first, count how often each number pops up
        // for example, [1,2,2,3,3,3] => 1=1, 2=2, 3=3.
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // we want to reverse the order; each frequency should be tied with the integers that
        // appear that amount of times. 
        // we start by creating an empty array of integer arrays
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) { // we do <= because if we have an array [2, 2] 
                                                 // 2 appears twice, so we need to include 2, 
                                                 // which is nums.length, to our frequencies
            buckets.add(new ArrayList<>());
        }

        // Index (freq):    0     1     2     3     4     5     6
        // buckets:        [ [],   [],   [],   [],   [],   [],   [] ]
        List<Integer> distinct = new ArrayList<>(count.keySet());
        for (int i = 0; i < distinct.size(); i++) {
            int num = distinct.get(i);
            int freq = count.get(num);
            buckets.get(freq).add(num);
        }

        int[] result = new int[k];
        int filled = 0;

        for (int freq = buckets.size() - 1; freq >= 1; freq--) {
            List<Integer> bucket = buckets.get(freq);
            for (int i = 0; i < bucket.size(); i++) {
                result[filled] = bucket.get(i);
                filled++;

                if (filled == k) {
                    return result;
                }
            }
        }

        return result;


        
    }
}
