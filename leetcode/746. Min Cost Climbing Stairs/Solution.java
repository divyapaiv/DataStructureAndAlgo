/*
'''
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
Choices : either first step or 2nd step 
dp will initially have first two step count 
Eg: cost = [1,100,1,1,1,100,1,1]
dp[0] = 1
dp[1] = 100
dp[2]= min(dp[1]+1,dp[0]+1) ~~     min(100+1,1+1) == 2
dp[3]= min(dp[2]+1,dp[1]+1) ~~     min(2+1,100+1) == 3
dp[4]= min(dp[3]+1,dp[2]+1) ~~     min(3+1,  2+1) == 3
dp[5]= min(dp[4]+100,dp[3]+100) ~~ min(3+100,  3+100) == 103
dp[6]= min(dp[5]+1,dp[4]+1) ~~     min(103+1,  3+1) == 4
dp[7]= min(dp[6]+1,dp[5]+1) ~~     min(5, 103+1) ==5
DP=[1, 100, 2, 3, 3, 103, 4, 5]
min(4,5) is 4 
'''
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int []dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1]; 
        for(int i=2;i<cost.length;i++){
            dp[i]= Math.min(dp[i-2]+cost[i],dp[i-1]+cost[i]);
        }
        return(Math.min(dp[cost.length-1],dp[cost.length-2]));
    }
}
