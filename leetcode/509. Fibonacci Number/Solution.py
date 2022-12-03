class Solution:
    def fib(self, n: int) -> int:
        if n==0: 
            return 0 
        fib_dp = list()
        fib_dp.append(0)
        fib_dp.append(1)
        for i in range(2,n+1):
            fib_dp.append(fib_dp[i-1]+fib_dp[i-2])
        return(fib_dp[n])
