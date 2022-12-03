class Solution {
    public int tribonacci(int n) {
        int [] fin_dp = new int[Math.max(3,n+1)];
        fin_dp[0] = 0;
        fin_dp[1] = 1;
        fin_dp[2] = 1;
        if(n<=2){
            return fin_dp[n];
        }
        for(int i = 3; i <= n ; i++){
            fin_dp[i]=fin_dp[i-1]+fin_dp[i-2]+fin_dp[i-3];
            
        }
        return(fin_dp[n]);
    }
 
}
