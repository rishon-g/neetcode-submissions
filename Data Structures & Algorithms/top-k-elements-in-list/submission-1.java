class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // nums = [5, 5, 9, 1, 1, 1]
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num,0) + 1);
            // count = {5:2, 9:1, 1:3}
        }

        
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        // distinct = [5, 9, 1]
        List<Integer> distinct = new ArrayList<>(count.keySet());
        for (int i = 0; i < distinct.size(); i++) {
            // say i = 0
            int num = distinct.get(i); // num = 5 
            int freq = count.get(num); // freq = 2 
            buckets.get(freq).add(num); // put 5 into bucket 2
        }


        int[] result = new int[k];
        int filled = 0;

        
        for (int freq = buckets.size() - 1; freq >= 1; freq--) {
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
