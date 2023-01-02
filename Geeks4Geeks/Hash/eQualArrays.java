//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        HashMap<Long,Integer> hs =new HashMap<Long,Integer>();
        int count=0;
        for(int i=0;i<N;i++){
            if(!hs.containsKey(A[i]))
            {
               hs.put(A[i],1);
            }
            else 
            {
                hs.put(A[i],hs.get(A[i])+1);
            }
            
        }
         for(int i=0;i<N;i++){
            if(!hs.containsKey(B[i]))
            {
              return false;
            }
            else 
            {
                int curval=hs.get(B[i]);
                if(curval-1<0) return false;
                
                hs.put(B[i],curval-1);
            }
        }
            return true;

    }
}
