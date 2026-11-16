// key idea: we first put all numbers into a hashset for O(1) lookups and duplicate removal.
// then, we place the numbers into an array list so we can iterate over all of these unique numbers simply
// we check if x-1 exists first, because if it does, we dont start counting from midway of a sequence, we skip it and iterate until we find this x-1 value. once it is found, we check if x+length exists and iterate on length. if length is > our current longest value, its replaced, and we keep doing this process until we find the longest consecutive streak

// time complexity: O(n)
// space complexity: O(n)


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

        }

        int longest = 0;
        List<Integer> unique = new ArrayList<>(set);

        for (int i = 0; i < unique.size(); i++) {
            int x = unique.get(i);

            if (!set.contains(x-1)) {
                int length = 1;
                while (set.contains(x+length)) {
                    length++;
                }

                if (length > longest) {
                longest = length;
                }
            }

            
        }
        

        return longest;
    }
}
