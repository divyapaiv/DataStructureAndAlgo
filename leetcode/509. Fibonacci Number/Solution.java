class Solution {
    public int fib(int n) {
        int [] fin_dp = new int[n+1];
        if(n==0) return 0;
        fin_dp[0] = 0;
        fin_dp[1] = 1;
        for(int i = 2; i <= n ; i++){
            fin_dp[i]=fin_dp[i-1]+fin_dp[i-2];
            
        }
        return(fin_dp[n]);
    }
}
