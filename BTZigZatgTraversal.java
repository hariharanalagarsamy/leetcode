/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150
class BTZigZatgTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> stack1 = new Stack<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        stack1.add(root);
        boolean flipFlag = false;
        while (!stack1.isEmpty()) {
            Stack<TreeNode> stack2 = new Stack<>();
            List<Integer> levelList = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                levelList.add(node.val);
                if(!flipFlag) {
                    addToStack(stack2, node.left, node.right);
                }
                else{
                    addToStack(stack2, node.right, node.left);
                }

            }
            stack1 = stack2;
            flipFlag = !flipFlag;
            result.add(levelList);
        }
        return result;
    }

    public void addToStack(Stack<TreeNode> stack, TreeNode p, TreeNode q) {
        if (p != null) {
            stack.add(p);
        }
        if (q != null) {
            stack.add(q);
        }
    }
}
