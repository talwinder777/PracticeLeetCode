/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Time Complexity -----> O(Number of Nodes)




class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return findMaxDepth(root, 0, 0) + 1;
        
    }
    public int findMaxDepth(TreeNode root, int maxi, int level){
//         int localMax = Math.max(maxi, level);
//         if(root.left == null && root.right == null){
//             // System.out.println("max = "+localMax+" level = "+level);
//             return localMax;
//         }
       
//         int left = 0, right = 0;
//         if(root.left != null)
//             left = findMaxDepth(root.left, localMax, level+1);
//         if(root.right != null)
//             right = findMaxDepth(root.right, localMax, level+1);
//         return Math.max(left,right);
        
        if (root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }
}