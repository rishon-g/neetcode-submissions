class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);

            // check if this window is the longest so far

            int length = right - left + 1; // (or window.size())
            if (length > best) {
                best = length;
            }

        }
        return best;

        

        
    }
}
