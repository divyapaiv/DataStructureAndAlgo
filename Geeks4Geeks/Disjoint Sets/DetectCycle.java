//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    
    int []parent;
    int []rank;
    public void initialize(int N){
        parent=new int[N];
        rank=new int[N];
        for(int i=0;i<N;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public Boolean union(int a,int b){
        if(parent[a]== parent[b]) return false;
        int x=find(parent[a]);
        int y=find(parent[b]);
       /* if(a==5 || b==5){
            System.out.println("A:"+a+" B "+b);
            System.out.println("X:"+x+" Y "+y);
            System.out.println(Arrays.toString(parent));
        }*/
        if(parent[a]!=parent[b] && x==y) return true; 
        else 
        {
            if (rank[a]<rank[b]){
                parent[x]=y; 
                
            }
            else if(rank[b]<rank[a]){
                parent[y]=x;
            }
            else {
                parent[x]=y; 
                rank[y]++;
            }
        }
        return false;
        
    }
    public int find(int x){
        if(parent[x]==x) return x; 
        else 
        return(find(parent[x]));
    }
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        initialize(V);
        for(int i=0;i<adj.size();i++){
          //  System.out.println(adj.get(i));
           for(int j=0;j<adj.get(i).size();j++){
               
                     int v1=i;
                     int v2=adj.get(i).get(j);
                     int pos=adj.get(v2).indexOf(i);
               //System.out.println(adj.get(v2));
              // System.out.println(adj.get(i));
               if(adj.get(i).get(j)!=-1){
               
                     //int v1_pos=adj.get(j).indexOf(i);
                     Boolean found_cycle=union(v1,v2);
                    // adj.get(i).set(j,-1);
                    // adj.get(v2).remove(pos);
                     if(found_cycle) return 1;
               }
               
               
           }
        }
        return 0;
    }
}
