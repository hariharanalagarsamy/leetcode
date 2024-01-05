/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
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
class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(result,root,0);
        return result;
    }

    public void levelOrderTraversal(List<List<Integer>> result, TreeNode root, int level){
        if(root == null){
            return;
        }
      //check if the list size is lesser than level to add list in the index 
      // this will be invoked only once for each level at the first recursion 
        if(result.size() < level + 1 ){ 
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrderTraversal(result,root.left,level + 1);
        levelOrderTraversal(result,root.right,level + 1);
    }
}
