// key idea: we create a HashMap (String, List<String>), and group each word by a key. 
// this key is attained by using an int[] array sized 26, where any word with the same # of 
// specific letters (act, cat) will belong to the same key [1, 0, 1, ...].
// this looks like {[1, 0, 1, 0 ...], [act, cat]}

// we iterate over every word in our string array, add each word to its corresponding group,
// and as a final step return an array with only the values because thats what we care about.

// Time complexity: O(m * n), m = #words, n = length of a word
// Space complexity: O(m * n), m words with length n 


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];

            int[] count = new int[26];

            for (int j = 0; j < word.length(); j++) {
                count[word.charAt(j) - 'a']++;
            }

            String key = Arrays.toString(count);


            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
        
    }
}
