/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Key idea: In-order traversal (left -> node -> right) visits a BST's nodes in ascending order.
// Use an explicit stack to simulate recursion iteratively:
// 1. Walk all the way left (while curr != null), pushing nodes onto the stack to reach the smallest unvisited value.
// 2. Pop the top node, decrement k, and return curr.val immediately when k == 0.
// 3. Move to curr.right to explore larger values in the right subtree before backtracking up the stack.
// Time complexity: O(h + k) [O(n) worst case] | Space complexity: O(h)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;

            if (k == 0) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1;
        
    }
}
