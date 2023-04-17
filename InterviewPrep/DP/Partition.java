//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        
        //reading input using BufferedReader class
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
            
        //taking testcases
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            
            //reading size of array
            int n = Integer.parseInt(br.readLine().trim());

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling findPartition() method and
            //printing "YES", if it returns true
            //else "NO"
            if (ob.findPartition(a, n) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java
/*Expected Time Complexity: O(N*S).
Expected Auxiliary Space: O(S) where S is the sum of the given Array.
https://practice.geeksforgeeks.org/batch/test-series-bundle/track/amazon-dynamic-programming/problem/subset-sum-problem2643
*/
class Solution 
{
    //Function to check whether a set of numbers can be partitioned into 
    //two subsets such that the sum of elements in both subsets is same.
    public boolean findPartition(int[] nums, int n)
    {
        int sum=0;
        
        for(Integer i: nums)
            sum = sum+i;
        
        if(sum%2 !=0)
            return false;
        
        else
            return partition_sum(nums , sum/2);
    }
    
    private boolean partition_sum(int[] nums ,int sum)
    {
        int n= nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for(int i=0; i<n+1;i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(i==0)
                    dp[i][j] = false;
                
                if(j==0)
                    dp[i][j] = true;
            }
        }
        
        for(int i=1; i<n+1;i++)
        {
            for(int j=0; j<sum+1;j++)
            {
                if(nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
}
