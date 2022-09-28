/**113. Path Sum II - https://leetcode.com/problems/path-sum-ii/
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
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
     List<List<Integer>> result; 
  //  HashSet<List<Integer> temp;
   public  Solution(){
       result = new  ArrayList<List<Integer>>();
    }
    public void findpath(TreeNode root, int targetSum,int currentsum,List<Integer> currentpath){
        //System.out.println(currentpath+" "+currentsum+" "+targetSum);
        
        if(root==null ){
            return;
        }
        currentsum=currentsum+root.val;
          if((currentsum) == targetSum && root.left==null && root.right==null){
              List<Integer> sub1 =new ArrayList<Integer>(currentpath) ;
                sub1.add(root.val);
                result.add(sub1);
            return;
        }
        
    
      
      
      
        // System.out.println(root.val);
        List<Integer> sub =new ArrayList<Integer>(currentpath) ;
     //   List<List<Integer>> right =ArrayList<List<Integer>>(currentpath) ;
        sub.add(root.val);
            findpath(root.left,targetSum,currentsum,sub);
            findpath(root.right,targetSum,currentsum,sub);
            
    
        }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new  ArrayList<List<Integer>>();
        findpath(root,targetSum,0,new ArrayList<Integer>());
        return(result);
    }
}