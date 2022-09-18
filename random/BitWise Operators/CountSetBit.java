//{ Driver Code Starts
//Initial Template for Java

/*
You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.

Your Task: The task is to complete the function countSetBits() that takes n as a parameter and returns the count of all bits.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 108*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    public static int getMaxpower(int n){
        int count=0;
            while((1<<count)<=n)
            {
                count++;
            }
        return(count-1);
    }
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
    if(n==0)
    return 0; 
    
    int count=0,x=n,pos=0,highest_pos=0,index=0;
    int maxpower= getMaxpower(n);
     /* 3 rows has same number of bits  */
    int firstpart=((int)Math.pow(2,maxpower-1)*maxpower)
    
    +(n-(int)Math.pow(2,maxpower)+1)
     +countSetBits(n-(int)Math.pow(2,maxpower));
    return(firstpart);
    }
}

//{ Driver Code Starts.

// Driver code
class CountSetBit {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends