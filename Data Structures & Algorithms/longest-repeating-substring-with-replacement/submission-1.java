class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            // right - left + 1 = length
            while ((right - left + 1) - mostCommon(count) > k) {
                count[s.charAt(left) - 'A']--;
                left++;

            }

            int length = right - left + 1;
            if (length > best) {
                best = length;
            }
        }

        return best;
    }

    private int mostCommon(int[] count) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        return max;
    }
}
