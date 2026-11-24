// key idea: keep adding letters to the window (hash set), until we run into a duplicate. in this case, remove the first instance of the letter (which is going to be the first letter in the window).
// by doing this, the latest instance of the letter is in the window but not the first. we repeat this process over.

// e.g., zxy -> zxyz -> xyz (and keep repeating).

// time complexity: O(n) with n being the length of s
// space complexity: O(min(n,m)) with m  being the size of the character set

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();

        int best = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);

            int length = right - left + 1;
            
            if (length > best) {
                best = length;
            }
        }

        return best;
    }
}
