class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // count how many times each number appears
        HashMap<Integer, Integer> count = new HashMap<>();  // eg., 1, 1 means 1 appears once.

        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1); 
        }   

        // buckets, where index = frequency
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        List<Integer> distinct = new ArrayList<>(count.keySet());
        for (int i = 0; i < distinct.size(); i++) {
            int num = distinct.get(i);
            int freq = count.get(num);
            buckets.get(freq).add(num);
        }

        // collect from the highest frequency down
        int[] result = new int[k];
        int filled = 0;

        for (int freq = buckets.size() -1; freq >= 1; freq--) {
            List<Integer> bucket = buckets.get(freq);
            for (int j = 0; j < bucket.size(); j++) {
                result[filled] = bucket.get(j);
                filled++;
                if (filled == k) {
                    return result;
                }
            }
        }

        return result;

    }
}
