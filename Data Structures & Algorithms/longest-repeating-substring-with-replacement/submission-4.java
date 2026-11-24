// key idea: use a window. each time we are not above having to do k replacements, we increase the window and thus the length. if we have to do more than k replacements, we change our window and see if the other letter can get us better results.

// example: AAABABB, k = 1

// iteration, length
// 1: A,        1
// 2: AA,       2
// 3: AAA,      3
// 4: AAAB,     4 (we only have to do 1 replacement here, so we're fine)
// 5: AAABA,    5 (still only one replacement)
// 6: AAABAB    
// -> BAB       3 (we must replace 2 > 1 letters, so we create a new window)
// 8: BABB      4

// in the end, we find our best length to be 5 (AAABA -> AAAAA after k = 1 replacement).
// time complexity: O(n), with n = string
// space complexity: O(1), because we create a fixed size integer array of 26 and nothing more than that

class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int best = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            while ((right - left + 1) - maxCount(count) > k) {
                count[s.charAt(left)-'A']--;
                left++;
            }

            int length = right - left + 1;
            if (length > best) {
                best = length;
            }

        }

        return best;
        
    }

    public int maxCount(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}
