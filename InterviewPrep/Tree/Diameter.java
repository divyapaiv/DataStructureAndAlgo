
class Solution {
    // Function to return the diameter of a Binary Tree.
   int ans;
    public Solution(){
       ans=0;
    }
    /* 
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
        
     }O(N*N)*/
    
 
    /*O(N)*/
    int getHeight(Node root){
        if(root==null) return 0;
          if(root==null) return 0;
            int lh=getHeight(root.left);
            int rh=getHeight(root.right);
            ans=Math.max(ans,lh+rh+1);
            return (1+Math.max(lh,rh));
        
     }
    int diameter(Node root) {
        getHeight(root);
      return ans;
        
    }
    
    
}
