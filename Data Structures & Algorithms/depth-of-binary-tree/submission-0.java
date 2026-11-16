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

 // key idea: a null node has depth 0. Every non-null node returns 1 (for itself) + the max depth between its left and right subtrees.

 // time complexity: O(n)
 // space complexity: O(n) (in the worst case, the recursion goes n levels deep, taking O(n) space)

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
    }
}
