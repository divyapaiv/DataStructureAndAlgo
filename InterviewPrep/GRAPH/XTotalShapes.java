class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length,cnt=0;
         boolean [][]visited= new boolean[n][m];
       for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(visited[i][j]==false && grid[i][j]=='X'){
                  dfs(i,j,visited,grid,n,m);
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
