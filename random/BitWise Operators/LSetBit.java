//{ Driver Code Starts
//Initial Template for Java
/*Given a number N. Find the length of the longest consecutive 1s in its binary representation.*/
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        int maxlen=0,curlen=0;
        while(N!=0){
		/* 3 in binary is 011 & if we and it with 3 if we get three that means we have consecutive set bit*/
            if((N&1)==1){
                curlen++;
               // System.out.println(curlen);
            }
            else{
            maxlen=curlen>maxlen?curlen:maxlen;
            curlen=0;
            }
            N=N>>1;
            
        }
        maxlen=curlen>maxlen?curlen:maxlen;
        return maxlen;
        
    }
}



//{ Driver Code Starts.

class LSetBit {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends