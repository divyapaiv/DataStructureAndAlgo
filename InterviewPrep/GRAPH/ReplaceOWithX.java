//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Position{
    int x;
    int y;
    public Position(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution{
    static void floodfill(int x,int y,char a[][],int n,int m,char curchar,char newchar){
        if(x<0 || y<0 || x>=n || y>=m) return;
        if(a[x][y]==curchar){
            a[x][y]=newchar;
            floodfill(x+1,y,a,n,m,curchar,newchar);
            floodfill(x-1,y,a,n,m,curchar,newchar);
            floodfill(x,y+1,a,n,m,curchar,newchar);
            floodfill(x,y-1,a,n,m,curchar,newchar);
        }
        
    }
    static char[][] fill(int n, int m, char a[][])
    { /*Replace O's with X's https://practice.geeksforgeeks.org/batch/test-series-bundle/track/GTS-GRAPH/problem/replace-os-with-xs0052
    This is mainly an application of Flood-Fill algorithm. 
    The main difference here is that a ‘O’ is not replaced by ‘X’ if it lies in region that ends on a boundary.
    Following are simple steps to do this special flood fill.

    1.Traverse the given matrix and replace all ‘O’ with a special character ‘-‘.
    2.Traverse four edges of given matrix and call floodFill(‘-‘, ‘O’) for every ‘-‘ on edges. The remaining ‘-‘ are the characters that indicate ‘O’s (in the original matrix) to be replaced by ‘X’.
    3.Traverse the matrix and replace all ‘-‘s with ‘X’s. 
*/
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='O'){
                    a[i][j]='-';
                }
            }
        }
        for(int j=0;j<m;j++){
            if(a[0][j]=='-'){
                floodfill(0,j,a,n,m,'-','O');
            }
            if(a[n-1][j]=='-'){
                floodfill(n-1,j,a,n,m,'-','O');
            }
        }
        
        for(int j=0;j<n;j++){
            if(a[j][0]=='-'){
                floodfill(j,0,a,n,m,'-','O');
            }
            if(a[j][m-1]=='-'){
                floodfill(j,m-1,a,n,m,'-','O');
            }
        }
        
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='-'){
                    floodfill(i,j,a,n,m,'-','X');
                }
            }
        }
        return a;
       
            
    
    }
}
