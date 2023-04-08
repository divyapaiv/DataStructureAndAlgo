class Solution
{
    
     void floodfill(int x,int y,int a[][],int n,int m,int curchar,int newchar){
        if(x<0 || y<0 || x>=n || y>=m) return;
        if(a[x][y]==curchar){
            a[x][y]=newchar;
            floodfill(x+1,y,a,n,m,curchar,newchar);
            floodfill(x-1,y,a,n,m,curchar,newchar);
            floodfill(x,y+1,a,n,m,curchar,newchar);
            floodfill(x,y-1,a,n,m,curchar,newchar);
        }
        
    }
    public int closedIslands(int[][] grid, int N, int M)
    {
       int n=N;
        int m=M,cnt=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=9;
                }
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==9){
                floodfill(0,j,grid,n,m,9,1);
            }
            if(grid[n-1][j]==9){
                floodfill(n-1,j,grid,n,m,9,1);
            }
        }
        
        for(int j=0;j<n;j++){
            if(grid[j][0]==9){
                floodfill(j,0,grid,n,m,9,1);
            }
            if(grid[j][m-1]==9){
                floodfill(j,m-1,grid,n,m,9,1);
            }
        }
       //  boolean [][]visited= new boolean[n][m];
       for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==9){
                  floodfill(i,j,grid,n,m,9,1);
                  cnt++;
              }
          }
       }
       return cnt;
    }
    
    public void dfs(int x,int y,boolean [][]visited,char[][] grid,int n,int m){
        if(x<0 || y<0 || x>=n || y>=m) return;
        if(visited[x][y]==false && grid[x][y]=='X'){
            visited[x][y]=true; 
            dfs(x+1,y,visited,grid,n,m);
            dfs(x-1,y,visited,grid,n,m);
            dfs(x,y+1,visited,grid,n,m);
            dfs(x,y-1,visited,grid,n,m);
        }
    }
}
