//{ Driver Code Starts
/*
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public  boolean isSafe(boolean graph[][],int n,int v,int c,int [] colors){
           //System.out.println(Arrays.deepToString(graph));
         // System.out.println(v);
        for(int i=0;i<n;i++){
           // if(v==4){
            //System.out.println(graph[i][v]+" "+colors[i]);
             
          //  }
            if((i!=v && graph[i][v]==true && colors[i]==c) )
                return false; 
           
        }
        return true;
        
    }
    public  boolean colorGraph(boolean graph[][],int m,int n,int v,int [] colors){
      
       if(v==n) return true;
         //System.out.println(m);
        for(int c=1;c<=m;c++){
            //System.out.println(c);
            if(isSafe(graph,n,v,c,colors)){
               // System.out.println(v);
                colors[v]=c;
                if(colorGraph(graph,m,n,v+1,colors)) return true;
                 
            }
             
        }
       //System.out.println(Arrays.toString(colors));
        
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
         int []colors=new int[n];
        // System.out.println(n);
         if(m==0) return false;
        for(int i=0;i<n;i++){
            colors[i]=0;
        }
        if(!colorGraph(graph,m,n,0,colors))
        {
            return false;
        }
        
       
        return true;
        
    }
}
