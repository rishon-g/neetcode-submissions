// key idea: find the starting brackets, add them to the stack. if we dont have a starting
// bracket, we pop the stack and see if the bracket on top matches (hardcoded for each)

// time complexity: O(n)
// space complexity: O(n)

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }

            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
                if (c == ')' && top != '(') return false;
            }

        }

        return stack.isEmpty();
        
    }
}
