
class Solution
{
    ArrayList <Integer> res;
    public Solution(){
        res=new ArrayList <Integer>();
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
       Map<Integer,Integer> bottomView = new TreeMap<>();
       ArrayDeque<Node> bfs= new ArrayDeque<>(); 
      
       root.hd=0;
       bfs.offer(root);
        /*14 14 3 N 8 8 12 N 6 17 3 N 1 11 10 N 6 6 13 N 10 17 7 N 11 7
        6 3 13 10 17 11 7 11 7 6*/
        /*7 6 7 13 11 10 correct*/
        
         while(bfs.size()>0){
            Node cur=bfs.poll();
            //if(!bottomView.containsKey(cur.hd)){
               bottomView.put(cur.hd,cur.data) ;
           // }
            if(cur.left!=null) {
            cur.left.hd=cur.hd-1;
            bfs.offer(cur.left);
            }

            if(cur.right!= null) {
                cur.right.hd=cur.hd+1;
                //res.add(cur.data);
               bfs.offer(cur.right);
            }
          }
          for( Integer i: bottomView.keySet()){
              res.add(bottomView.get(i));
          }
                  return res;
        }

        
    
}
