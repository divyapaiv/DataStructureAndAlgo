class Solution {


    public int longestCommonSubsequence(String text1, String text2) {
    int n=text1.length();
    int m=text2.length();
     int [][] cache = new int[n+1][m+1];
     for(int i=0;i<=n;i++)
        cache[i][0]=0;
     for(int i=0;i<=m;i++)
        cache[0][i]=0;
     for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
             if(text1.charAt(i)==text2.charAt(j)){
                 cache[i+1][j+1]=Math.max(Math.max(1+cache[i][j],
                 cache[i+1][j]),cache[i][j+1]);
             }
             else
             {
                 cache[i+1][j+1]=Math.max(cache[i+1][j],cache[i][j+1]);
             }
             }
         }
         System.out.println(Arrays.deepToString(cache));
         return cache[n][m];
     }     
    
}
