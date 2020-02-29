/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Just flip the left and right nodes of root and recurese on the left and right

// Time Complexity - O(number of Nodes)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
        invert(root); 
        return root;
    }
    public void invert(TreeNode root){
        
        if(root == null || (root.left == null && root.right == null))
            return;
        
        TreeNode Temp = root.right;
        root.right = root.left;
        root.left = Temp;
        
        invert(root.left);//though calling in the order of left and then right but in actual right gets called first because the address were changed before this line
        invert(root.right);
    }
}