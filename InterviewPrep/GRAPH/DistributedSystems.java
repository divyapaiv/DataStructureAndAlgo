//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            int[][] edges = new int[E][3];
            
            for(int i=0; i<E; i++)
            {
                String S[] = read.readLine().trim().split(" ");
                for(int j=0; j<3; j++)
                    edges[i][j] = Integer.parseInt(S[j]);
            }
            
            Solution ob = new Solution();
            
            int res = ob.distributedSystems(V, edges);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends



//User function Template for Java
class NodeInfo{
    int dest;
    int t,p;
    public NodeInfo(int dest,int t,int p){
        this.dest=dest;
        this.t=t;
        this.p=p;
    }
    @Override
    public String toString(){
        return ("Destination : "+ dest +"\tTime: "+t);
    }
}
class Solution
{
    static int distributedSystems(int V, int[][] edges)
    {
        int []vis=new int[V+1];
        if(V==0) return 0;
        if(edges.length==1) return edges[0][2];
        int cnt=0;
        HashSet<NodeInfo> Visited =new HashSet<>();
        HashSet<NodeInfo> temp =new HashSet<>();
        ArrayList<ArrayList<NodeInfo>> graph=new ArrayList<>();
        PriorityQueue<NodeInfo> queue = new PriorityQueue<NodeInfo>((a,b)->{
            return(a.t-b.t);
        });
        PriorityQueue<NodeInfo> finalQueue = new PriorityQueue<NodeInfo>((a,b)->{
            return(a.t-b.t);
        });
        
        
        
        NodeInfo dummyNode=new NodeInfo(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
        for(int i=0;i<=V;i++){
            graph.add( new ArrayList<NodeInfo>());
            vis[i]=Integer.MAX_VALUE;
            
        }
        int a=0,b=0,t=0;
         for(int i=0;i<edges.length;i++){
              try{
            a=edges[i][0];
            b=edges[i][1];
            t=edges[i][2];
            NodeInfo n=new NodeInfo(b,t,a);
            NodeInfo n1=new NodeInfo(a,t,b);
            graph.get(a).add(n);
            graph.get(b).add(n1);
            if(a==0 ){
                queue.offer(n);
            }
            //if(b==0){
            //    queue.offer(n1);
            //}
            }catch(Exception e){
                System.out.println(i+" exc"+a+ " "+b);
            }
            
        }
        int curmax=Integer.MIN_VALUE;
         /*for(int i=0;i<graph.get(0).size();i++){
            queue.offer(graph.get(0).get(i));
        }*/
 
        vis[0]=0;

        int maxvalue=Integer.MIN_VALUE; 
        curmax=Integer.MIN_VALUE;
        NodeInfo lastNode=null;
        queue.offer(dummyNode);
       while(queue.size()>0){
            
            NodeInfo cur=queue.poll();
            temp.add(cur);
    
            if(cur==dummyNode){
                if(queue.size()>0){
                     queue.offer(dummyNode);
                }
                for(NodeInfo i:temp){
                    Visited.add(i);
                }
                temp.clear();
                
            }
            else{
                vis[cur.dest]=Math.min(vis[cur.dest],cur.t+vis[cur.p]);
                for(int i=0;i<graph.get(cur.dest).size();i++){
                   NodeInfo subnode=graph.get(cur.dest).get(i);
                   if(!Visited.contains(subnode) && vis[subnode.dest]>(subnode.t+vis[subnode.p])){
                       vis[subnode.dest]=subnode.t+vis[subnode.p];
                       graph.get(cur.dest).get(i).t=subnode.t+vis[subnode.p];
                        queue.offer(graph.get(cur.dest).get(i));
                      //  finalQueue.offer(graph.get(cur.dest).get(i));
                         //queue.offer(graph.get(subnode.dest).get(i));
                        
                   }
                   
                }
            }
             

        }

        
        for(int i=0;i<vis.length;i++){
            maxvalue=Math.max(vis[i],maxvalue);
        }
       
        return maxvalue;
        
    }
   
}
