

//User function Template for Java
class NodeHead{
    Node node;
    Integer hd; 
    public NodeHead( Node node,Integer hd){
        this.node=node;
        this.hd=hd;
    }
}

class Solution
{
    
    /*  
                14
            14           3 
        N       8     8    12 
      N    6  17  3  N  1 11  10
    N   6  
    
    
    
    */
    //Function to find the vertical order traversal of Binary Tree.
    static void getVerticalOrder(Node root, Map<Integer,ArrayList<Integer>> bottomView,int curhd, int level)
    {
        if(root==null) return;
        else{
            if(level==0){
                if(bottomView.containsKey(curhd)){
                    bottomView.get(curhd).add(root.data);
                 }
                 else{
                    bottomView.put(curhd,new ArrayList<>());
                    bottomView.get(curhd).add(root.data);
                }
            }
            getVerticalOrder(root.left,bottomView,curhd-1,level-1);
            getVerticalOrder(root.right,bottomView,curhd+1,level-1);
           
            
        }
    }
    static int getHeight(Node root){
        if(root==null) return 0;
        else return 1+Math.max(getHeight( root.left),getHeight( root.right));
    }
    static ArrayList <Integer> verticalOrder(Node root)
    {
         ArrayList <Integer> res= new  ArrayList <Integer>();
       Map<Integer,ArrayList<Integer>> bottomView = new TreeMap<>();
        /*14 14 3 N 8 8 12 N 6 17 3 N 1 11 10 N 6 6 13 N 10 17 7 N 11 7
        6 3 13 10 17 11 7 11 7 6*/
        /*7 6 7 13 11 10 correct*/
        int height=getHeight(root);
        for(int level=0;level<height;level++)
            getVerticalOrder(root,bottomView,0,level);
        
          for( Integer i: bottomView.keySet()){
            //  System.out.print(i+" ");
              for(Integer k:bottomView.get(i)){
            // System.out.print(k+" ");
                res.add(k);
              }
              // System.out.println(" ");
          }
                  return res;
    }
}
