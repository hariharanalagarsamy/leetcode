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
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        flattenHelper(nodeList,root);
        nodeList.add(null);
        for(int i=0;i<nodeList.size() - 1;i++){
            TreeNode node = nodeList.get(i);
            node.left = null;
            node.right = nodeList.get(i + 1);
        }
    }

    public void flattenHelper(List<TreeNode> nodeList, TreeNode root){
        if(root == null){
            return;
        }
        nodeList.add(root);
        flattenHelper(nodeList, root.left);
        flattenHelper(nodeList, root.right);
    }
}
