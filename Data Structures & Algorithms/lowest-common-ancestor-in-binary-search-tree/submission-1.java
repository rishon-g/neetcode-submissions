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

 // Key idea: Use BST ordering to walk down from root—go right if both > curr, left if both < curr.
// The first node where p and q split (or where curr == p or q) is the LCA.

// Time: O(h) 
// Space: O(1)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }

            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }

            else {
                return curr;
            }



        }

        return null;
    }
}
