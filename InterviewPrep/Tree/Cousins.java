class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        //code here
         ArrayList<Integer> res= new  ArrayList<Integer>();
  
        if(root ==null || node_to_find== root) {res.add(-1);
        return res;
            
        }
        ArrayDeque<Node> bfs=new  ArrayDeque<Node>();
        Node dummyNode= new Node(-1);
        bfs.offer(root);
        bfs.offer(dummyNode);
        boolean found=false;
        Node left=null,right=null;
        while(bfs.size()>0){
            Node current=bfs.poll();
            if(current==dummyNode && bfs.size()>0){
                 bfs.offer(dummyNode);
            }
            if(current.left!=null ){
                bfs.offer(current.left);
                if(current.left==node_to_find){
                    found=true;
                }
            }
            if(current.right!=null ){
                bfs.offer(current.right);
                 if(current.right==node_to_find){
                    found=true;
                }
            }
            if(found==true && left==null && right == null){
                left=current.left;
                right=current.right;
            }
            if(found==true && current==dummyNode){
                while(bfs.size()>0){
                    Node cur=bfs.poll();
                    if(cur!=left && cur!=right && cur!=dummyNode){
                        res.add(cur.data);
                    }
                }
            }
        }
        if(res.size()==0) res.add(-1);
        return res;
    }
}
