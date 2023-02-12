//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

  public class GFG {
    public static int N = 0;
    public static void main(String[] args) {
        // code
        Scanner a = new Scanner(System.in);
        int T = a.nextInt();
        for (int z = 0; z < T; z++) {
            N = a.nextInt();

            int[][] maze = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int o = 0; o < N; o++) maze[y][o] = a.nextInt();
            }

            new RatInMaze().solve(maze, N);
        }
    }

    public static void print(int N, int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends



class RatInMaze 
{
    //Function to find the minimum number of Hops required for the rat to 
    //reach from the source block to the destination block.
    public static boolean isSafe(int[][] maze,int i,int j,int N){
        if(maze[i][j]>0 || (i==N-1 && j==N-1)) return true;
        return false;
    }
     public static void print(int[][] result,int N){
        {
            for(int i=0;i<N;i++){
               for(int j=0;j<N;j++){
                   System.out.print(result[i][j]+" ");
                
            } 
            System.out.print("\n");
            }
        }
    }
    public static boolean traverseMaze(int[][] maze, int i,int j,int[][] result,int N )
    {
        //System.out.println()
        if(i==N-1 && j==N-1){
            print(result,N);
            return true;
        }
        if(i>=N || j>=N) return false;
        int initial_steps=maze[i][j];
        result[i][j]=1;
        if(initial_steps==0 && i!=N-1 && j!=N-1 ) return false; 
       
            for(int k=1;k<=initial_steps;k++)
            {
                if(j+k<N && isSafe(maze,i,j+k,N)){
                result[i][j+k]=1;
                 if(traverseMaze(maze,i,j+k,result,N))
                {
                    //
                    return true;
                }
                
                result[i][j+k]=0;
                }
                 if(i+k<N && isSafe(maze,i+k,j, N)){
                result[i+k][j]=1;
                if(traverseMaze(maze,i+k,j,result,N))
                { 
               // 
                return true;
                 }
                 result[i+k][j]=0;
            }
            }

              
        
        return false;
    }
    public static void solve(int[][] maze, int N)
    {
        if(N==1) System.out.println("1");
        else if(maze[0][0]<=0) System.out.println("-1");
        else if(!traverseMaze(maze,0,0,new int[N][N],N)) System.out.println("-1");
    }
}

