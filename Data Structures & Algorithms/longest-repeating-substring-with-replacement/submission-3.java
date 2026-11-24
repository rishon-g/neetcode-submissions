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
