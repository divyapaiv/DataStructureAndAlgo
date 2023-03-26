//Function to connect nodes at same level.
    public void connect(Node root)
    {
        ArrayDeque<Node> bfs=new ArrayDeque<>();
        Node tempNode=new Node(-1);
        Node prev=null;
        if(root==null) return;
        bfs.offer(root);
        bfs.offer(tempNode);
        root.nextRight=null;
        while(bfs.size()>0){
            Node cur=bfs.poll();
            if((cur==tempNode && bfs.size()>0))
            {
                prev=null;
                bfs.offer(tempNode);
            }
            else{
                if(cur.left!=null)
                    bfs.offer(cur.left);
                 if(cur.right!=null)
                    bfs.offer(cur.right);
                 if(prev!=null){
                    if(cur!= tempNode){
                        prev.nextRight=cur;
            
                    }
                    else{
                        prev.nextRight=null;
                    }
                 }
                 prev=cur;
            }
            
        }
    }
