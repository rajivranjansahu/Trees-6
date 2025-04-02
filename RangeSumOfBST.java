// TC: O(n)
// SC: O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class Solution {
    // Recursive DFS, TC = O(n), SC = O(h)
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        dfs(root, low, high);
        return sum;
    }
    private void dfs(TreeNode root, int low, int high) {
        // base
        if(root == null) return;
        // logic
        if(root.val > low) // optimization - pruning - avoid traversing subtrees that cannot contain values in the [low, high] range 
             dfs(root.left, low, high);
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if(root.val < high) dfs(root.right, low, high);
    }

    // Conventional Iterative TC = O(n), SC = O(h)
    // public int rangeSumBST(TreeNode root, int low, int high) {
    //     if(root == null) return 0;
    //     int sum = 0;
    //     Stack<TreeNode> s = new Stack<>();
    //     while(root != null || !s.isEmpty()) {
    //         while(root != null) {
    //             if(root.val < low) { // Current node is smaller skip left subtree, but fo to leftm as it might contain vals in range
    //                 root = root.right;
    //             }
    //             else {
    //                 s.push(root);
    //                 root = root.left;
    //             }
    //         }
    //         root = s.pop();
    //         if(root.val >= low && root.val <= high) {
    //             sum += root.val;
    //         }
    //         if(root.val > high) { //  If the current node is greater than high, its right subtree can be skipped.
    //             root = null;
    //         }
    //         else {
    //             root = root.right;
    //         }
    //     }
    //     return sum;
    // }

    // Iterative TC = O(n), SC = O(h)
    // public int rangeSumBST(TreeNode root, int low, int high) {
    //     if(root == null) return 0;
    //     int sum = 0;
    //     Stack<TreeNode> s = new Stack<>();
    //     s.push(root);
    //     while(root != null || !s.isEmpty()) {
    //         root = s.pop();
    //         if(root != null && root.val > low) { // 5 > low = false, don't push left
    //             s.push(root.left);
    //         }
    //         if(root != null && root.val < high) { // 5 < high = true, push 7
    //             s.push(root.right);
    //         }
    //         if(root != null && root.val >= low && root.val <= high) { // But 5 is NOT in range, so skip adding to sum (this is why the check is needed)
    //             sum += root.val;
    //         }
    //     }
    //     return sum;
    // }
}