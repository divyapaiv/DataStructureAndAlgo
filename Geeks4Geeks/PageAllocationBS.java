//{ Driver Code Starts
//Initial Template for Java
//https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/problem/allocate-minimum-number-of-pages0937
/*package whatever //do not write package name here */
/*
You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate contiguous books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is the minimum of those in all the other permutations and print this minimum value.

Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

 
 */
import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static Boolean isFeasible(int[]A,int N,int mid,int M){
         int req=0,cursum=0;;
         for(int i=0;i<N;i++){
             if(cursum+A[i]<=mid)
                cursum+=A[i];
             else{
                 req++;
                 cursum=A[i];
             }
             
         }
         if(cursum>0){
             req++;
         }
         if(req<=M)
            return true; 
         else 
            return false;
     }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
      
        int sum=0;
        int curmax=Integer.MIN_VALUE;
        int mid=0;
        int res=-1;
            if(N<M) return -1;
            for(int i=0;i<N;i++){
                sum+=A[i];
                curmax= Math.max(curmax,A[i]);
            }
            //low = Minimum value which we may get which max of an array
            //high = maximum value which we can anticipate which is sum of all elements in an array
            //if m==1 just return sum
            if(M==1) return sum;
            
            int high= sum; 
            int low= curmax; 
           
            while(low<=high){
                mid=(low + high)/2;
                //find mid point between low and high and check if we can try allocating books
                //if yes try smaller value to know if there are any more feasible solution
                //<max value>--------------------<<MID>>-------------------------<Sum>
                //If Feasible found
                //<max value>-------------------<<MID-1>>
                //else 
                //                              <<MID+1>>-------------------------<Sum>
                if(isFeasible(A,N,mid,M)){
                    res=mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
                
            }
            //System.out.println(low);
          //System.out.println(high);
            return res;
            
        }
        
     
    }
