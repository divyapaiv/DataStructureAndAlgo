/* O(N)*/
class Solution {
    // Function to return the diameter of a Binary Tree.
    int curmax;
    public Solution(){
        curmax=Integer.MIN_VALUE;
    }
    int diameter(Node root) {
       if(root==null) return 0;
        int d1=diameter(root.left);
        int d2=diameter(root.right);
        int l=getHeight(root.left,Integer.MIN_VALUE);
        int r=getHeight(root.right,Integer.MIN_VALUE);
        int cur=1+l+r; 
        return(Math.max(cur,Math.max(d1,d2)));
    }
     int getHeight(Node root,int res){
        if(root==null) return 0;
        return (1+Math.max(getHeight(root.left,res),getHeight(root.right,res)));
        
     }
}
