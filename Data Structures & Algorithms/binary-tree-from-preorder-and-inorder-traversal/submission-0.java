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

// Key idea: Preorder (root -> left -> right) gives each subtree's root in order,
// while Inorder (left -> root -> right) splits the remaining nodes into left and right subtrees.
// 1. Map each inorder value to its index in a HashMap for O(1) root lookups.
// 2. Track a global preIndex to grab the next rootVal from preorder and create the node.
// 3. Look up mid = inorderMap.get(rootVal), then recursively build left [left, mid - 1]
//    BEFORE right [mid + 1, right] so preIndex advances in exact preorder sequence.
// 4. Base case: if (left > right) return null (empty subtree).
// Time complexity: O(n) | Space complexity: O(n)

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length -1);
        
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}
