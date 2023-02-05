//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

//Edge class to store
//source, destination, and weight
class Edge
{
    int src;
    int des;
    int wt;
    //long w;
    Edge(int src, int des, int wt)
    {
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}

class Driver_code
{
    public static void main (String[] args)throws IOException {
        
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        //creating an List of Edge type
        ArrayList<Edge> adj = new ArrayList<>();
        while(t-- >0)
        {
            //taking number of nodes and edges
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            
            int u, v;
            int w;
            
            //adding src,des,wt to the ArrayList
            for(int i = 0; i < m; i++)
            {
                str = read.readLine().trim().split(" ");
                int k = 0;
                u = Integer.parseInt(str[k++]);
                v = Integer.parseInt(str[k++]);
                w = Integer.parseInt(str[k++]);
                
                Edge edg = new Edge(u,v,w);
                adj.add(edg);
                
            }
            
            //calling kruskalDSU() method of class
            //DSU and passing ArrayList, nodes and edges
            System.out.println(new DSU().kruskalDSU(adj, n, m));
             adj.clear();
            // for(int i = 0; i <= n; i++)
            //  adj.get(i).clear();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/**
 *  ith value in adj vector contains information between the node connected to it and weight between them.
 *  Example. for a value 2 3 1, Node 2 and Node 3 has weight 1. adj[2] = {3,1} and adj[3] = {2,1}.
 *  n -> number of nodes
 *  m -> total number of edges
 *  return the mst value
 */
class EdgeCompare implements Comparator<Edge>{
    public int compare(Edge e1, Edge e2){
        if(e1.wt>e2.wt){
            return 1;
        }
        else if(e1.wt<e2.wt){
            return -1;
        }
        else 
        return 0;
    }
}
class DSU
{
    static void print(ArrayList<Edge> adj){
        System.out.println("Printing ArrayList");
        for(Edge e:adj){
            System.out.println(e.src+" "+ e.des+" "+ e.wt);
        }
    }
    static int find(int x,int []parent){
        if(parent[x]==x) return x;
        else 
        {parent[x]=find(parent[x],parent);
            return parent[x];
        }
    }
    static boolean union(int a, int b,int []parent,int [] rank){
        if(parent[a]==parent[b]){
            return false; 
        }
        else{
            int x=find(parent[a],parent);
            int y=find(parent[b],parent);
            if(x==y) return false;
            if(rank[a]<rank[b]){
                parent[x]=y;
            }
            else if(rank[a]>rank[b]){
                parent[y]=x;
            }
            else{
                parent[x]=y;
                rank[y]++;
                
            }
            return true;
        }
    }
    //Function to find the minimum spanning tree value using Kruskal.
    static long kruskalDSU(ArrayList<Edge> adj, int n, int m)
    {
        // add your code here
        //print(adj);
          int []parent= new int[n+1];
          int []rank= new int[n+1];
        Collections.sort(adj,new EdgeCompare());
      //  print(adj);
        long cost=0;
        
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(Edge e:adj){
            if(union(e.src,e.des,parent,rank)){
                cost+=e.wt;
            }
        }
        return cost;
    }
}

