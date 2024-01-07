/**
* https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
**/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulateRightPointerBT {
    public Node connect(Node root) {

        List<List<Node>> levelList = new ArrayList();
        constructLevelList(levelList,root,0);
        for(int i=0;i<levelList.size();i++){
            List<Node> node = levelList.get(i);
            for(int j=0;j<node.size() ;j++){
                node.get(j).next = (j + 1 < node.size()) ? node.get(j + 1) : null;
            }

            }
        return root;
        
    }

    public void constructLevelList(List<List<Node>> levelList,Node root, int level){
        if(root == null){
            return;
        }
        if(levelList.size() < level + 1){
            levelList.add(new ArrayList<>());
        }
        levelList.get(level).add(root);
        constructLevelList(levelList,root.left,level + 1);
        constructLevelList(levelList,root.right,level + 1);
    }
}
