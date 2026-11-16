// key idea: increment on both the left and right sides of the string towards the middle until
// we have a letter or digit (e.g., if we have !.;Helle.h!,,[ this is Helle.h)

// we compare h in the left with h in the right, find theyre the same, and continue the loop.
// in our next iteration, we first remove any unnecessary letters; elle. -> elle

// we keep comparing the leftmost letter with the rightmost letter until we have no more letters
// (left > right), this condition met means we have a palindrome

// time complexity:  O(n) (technically O(1/2n) but that s just O(n))
// space complexity: O(1)


class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }
}
