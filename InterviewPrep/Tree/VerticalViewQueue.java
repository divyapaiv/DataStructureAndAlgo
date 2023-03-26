/*https://practice.geeksforgeeks.org/batch/test-series-bundle/track/gts-trees/problem/print-a-binary-tree-in-vertical-order*/
static ArrayList <Integer> verticalOrder(Node root)
    {
       ArrayList <Integer> res= new  ArrayList <Integer>();
       Map<Integer,ArrayList<Integer>> bottomView = new TreeMap<>();
       Map<Node,Integer> curd = new HashMap<Node,Integer>();
        /*14 14 3 N 8 8 12 N 6 17 3 N 1 11 10 N 6 6 13 N 10 17 7 N 11 7
        6 3 13 10 17 11 7 11 7 6*/
        /*7 6 7 13 11 10 correct*/
       ArrayDeque<Node> bfs= new ArrayDeque<>();
       int curdistance=0;
       bfs.offer(root);
       curd.put(root,0);
        /*14 14 3 N 8 8 12 N 6 17 3 N 1 11 10 N 6 6 13 N 10 17 7 N 11 7
        6 3 13 10 17 11 7 11 7 6*/
        /*7 6 7 13 11 10 correct*/
        
         while(bfs.size()>0){
             
            Node cur=bfs.poll();
            if(curd.containsKey(cur)){
                curdistance=curd.get(cur);
             }
             if(bottomView.containsKey(curdistance)){
                    bottomView.get(curdistance).add(cur.data);
                 }
                 else{
                    bottomView.put(curdistance,new ArrayList<>());
                    bottomView.get(curdistance).add(cur.data);
                }
             if(cur.left!=null) {
                curd.put(cur.left,curdistance-1);
                bfs.offer(cur.left);
            }

            if(cur.right!= null) {
                curd.put(cur.right,curdistance+1);
                bfs.offer(cur.right);
            }
         }
        
        
        
        
        
        
        
        
        
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
