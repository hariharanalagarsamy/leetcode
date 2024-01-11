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
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
class SumToRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        TreeNode result = new TreeNode(0);
        sumNumbers(root,0,0,result);
        return result.val;

    }


    public void sumNumbers(TreeNode root,int level, int currentSum,TreeNode result) {
        if(root == null){
            return;
        }
        int temp = (currentSum * 10) + root.val;
        if(root.left == null && root.right == null){
            result.val = result.val + temp;
        }
        
        sumNumbers(root.left, level + 1, temp, result);
        sumNumbers(root.right, level + 1 , temp, result);
    }
}
