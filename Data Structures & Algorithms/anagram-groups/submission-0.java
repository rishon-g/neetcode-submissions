class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];

            int[] count = new int[26];

            for (int j = 0; j < word.length(); j++) {
                count[word.charAt(j)- 'a']++;
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
