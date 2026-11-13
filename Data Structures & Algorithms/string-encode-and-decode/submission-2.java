// key idea: we encode by appending both a number that signifies the 
// length and a hashtag to signify the beginning of the string
// for example, ["Hello", "World"] turns into 5#Hello5#World
// (we use StringBuilder to convert the array to a string)

// then to decode, we read this string and add to an array list
// accordingly.

// time complexity: O(n) (we iterate over the entire length twice)
// space complexity: O(n) (we create sb)


class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            int start = j + 1;

            result.add(str.substring(start, start + length));

            i = start + length;

        }

        return result;

    }
}
